package com.iteria.domain.interactors;

import com.iteria.data.AfiAfiliado;
import com.iteria.data.CtoContrato;
import com.iteria.data.PlnPlan;
import com.iteria.data.TdcTipoDocumento;
import com.iteria.domain.UseCaseVoid;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.AfiAfiliadoDto;
import com.iteria.domain.dto.PlnPlanDto;
import com.iteria.domain.entity.RegistrarAfiliadoEntity;
import com.iteria.domain.exception.GeneralException;
import com.iteria.domain.repositorio.IRepositorioAfiliado;
import com.iteria.domain.repositorio.IRepositorioContrato;
import com.iteria.domain.repositorio.IRepositorioPlan;
import com.iteria.domain.repositorio.IRepositorioTipoDocumento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para registrar afiliado.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
@Slf4j
@Service
public class RegistrarAfiliado extends UseCaseVoid<RegistrarAfiliadoEntity> {

    @Autowired
    private IRepositorioAfiliado repositorioAfiliado;
    
    @Autowired
    private IRepositorioTipoDocumento repositorioTipoDocumento;
    
    @Autowired
    private IRepositorioPlan repositorioPlan;
    
    @Autowired
    private IRepositorioContrato repositorioContrato;
    
    @Override
    protected void constructUseCase(RegistrarAfiliadoEntity entity) {
        log.info("Inicio registrar afiliado");
        AfiAfiliadoDto buscar = entity.getAfiliado();
        
        Optional<AfiAfiliado> af = repositorioAfiliado.findById(buscar.getId());
        if (af.isPresent()) {
            throw new GeneralException(String.format("Afiliado %s ya existe", buscar.getId()));
        } 
        
        PlnPlanDto buscarPlan = entity.getPlan();
        log.info("validar si afiliado tiene contrato");
        List<CtoContrato> contratos = repositorioContrato.findByAfiliado(buscar.getId());
        CtoContrato contrato = contratos.stream()
                .filter(f -> f.getFechaRetiro() == null)
                .filter(c -> c.getPlan().getId().equals(buscarPlan.getId()))
                .findAny()
                .orElse(null);
        
        if (contrato != null) {
            log.warn("afiliado ya esta registrado en esta plan");
            throw new GeneralException("Afiliado ya esta registrado a esta plan");
        }
        
        log.info("buscar plan");
        Optional<PlnPlan> plan = repositorioPlan.findById(buscarPlan.getId());
        if (plan.isEmpty()) {
            throw new GeneralException(String.format("Plan %s no existe", buscarPlan.getId()));
        } else if (plan.get().getEstado() == 0) {
            throw new GeneralException(String.format("Plan %s no esta activo", buscarPlan.getId()));
        }
        
        log.info("validar fecha fin de plan");
        DateTimeZone zone = DateTimeZone.forID("America/Lima");
        DateTime hoy = new DateTime(zone);
        DateTime fin = new DateTime(plan.get().getFechaFin());
        if (fin.isBefore(hoy)) {
            throw new GeneralException("el plan esta vencido");
        }
        
        log.info("buscar tipo documento");
        Optional<TdcTipoDocumento> tipo = repositorioTipoDocumento.findById(buscar.getTipoDocumento().getId());
        if (tipo.isEmpty()) {
            throw new GeneralException(String.format("Tipo de documento %s no existe", buscar.getTipoDocumento().getId()));
        } else if (tipo.get().getEstado() == 0) {
            throw new GeneralException(String.format("Tipo de documento %s no esta activo", tipo.get().getId()));
        }
        
        buscar.setEstado(1);
        AfiAfiliado afiliado = repositorioAfiliado.saveAndFlush(Mapper.mapper(AfiAfiliado.class, buscar));
        
        log.info("registrar contrato");
        CtoContrato nuevo = new CtoContrato();
        nuevo.setId(UUID.randomUUID().toString().substring(0, 20));
        nuevo.setAfiliado(afiliado);
        nuevo.setPlan(plan.get());
        nuevo.setCantidad(1);
        nuevo.setFechaInicio(new DateTime(zone).toDate());
        nuevo.setFechaRegistro(new DateTime(zone).toDate());
        nuevo.setFechaRetiro(null);
        nuevo.setEps("EPS");
        repositorioContrato.save(nuevo);
        log.info("Fin registrar afiliado");
    }
}
