package com.iteria.domain.interactors;

import com.iteria.data.AfiAfiliado;
import com.iteria.data.CtoContrato;
import com.iteria.domain.UseCaseVoid;
import com.iteria.domain.dto.AfiAfiliadoDto;
import com.iteria.domain.entity.AfiliadoEntity;
import com.iteria.domain.exception.GeneralException;
import com.iteria.domain.repositorio.IRepositorioAfiliado;
import com.iteria.domain.repositorio.IRepositorioContrato;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * caso de uso para dar de baja a afiliado.
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
public class DarBajaAfiliado extends UseCaseVoid<AfiliadoEntity> {

    @Autowired
    private IRepositorioAfiliado repositorioAfiliado;
    
    @Autowired
    private IRepositorioContrato repositorioContrato;
    
    @Override
    protected void constructUseCase(AfiliadoEntity entity) {
        log.info("Inicio baja afiliado");
        AfiAfiliadoDto buscar = entity.getAfiliado();
        
        Optional<AfiAfiliado> afiliado = repositorioAfiliado.findById(buscar.getId());
        if (afiliado.isEmpty()) {
            throw new GeneralException(String.format("Afiliado %s no existe", buscar.getId()));
        } else if (afiliado.get().getEstado() == 0) {
            throw new GeneralException(String.format("Afiliado %s no esta activo", buscar.getId()));
        }
        
        log.info("dar de baja afiliado");
        AfiAfiliado a = afiliado.get();
        a.setEstado(0); 
        repositorioAfiliado.save(a);
        
        log.info("buscar contratos");
        List<CtoContrato> contratos = repositorioContrato.findByAfiliado(buscar.getId());
        contratos.stream().filter(f -> f.getFechaRetiro() == null).forEach(c -> {
            DateTimeZone zone = DateTimeZone.forID("America/Lima");
            c.setFechaRetiro(new DateTime(zone).toDate());
            repositorioContrato.save(c);
        });
        
        log.info("Fin baja afiliado");
    }
}
