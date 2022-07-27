package com.iteria.domain.interactors;

import com.iteria.data.AfiAfiliado;
import com.iteria.data.TdcTipoDocumento;
import com.iteria.domain.UseCaseVoid;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.AfiAfiliadoDto;
import com.iteria.domain.entity.AfiliadoEntity;
import com.iteria.domain.exception.GeneralException;
import com.iteria.domain.repositorio.IRepositorioAfiliado;
import com.iteria.domain.repositorio.IRepositorioTipoDocumento;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para actualizar afiliado.
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
public class ActualizarAfiliado extends UseCaseVoid<AfiliadoEntity> {

    @Autowired
    private IRepositorioAfiliado repositorioAfiliado;
    
    @Autowired
    private IRepositorioTipoDocumento repositorioTipoDocumento; 
    
    @Override
    protected void constructUseCase(AfiliadoEntity entity) {
        log.info("Inicio actualizar afiliado");
        AfiAfiliadoDto buscar = entity.getAfiliado();
        
        Optional<AfiAfiliado> afiliado = repositorioAfiliado.findById(buscar.getId());
        if (afiliado.isEmpty()) {
            throw new GeneralException(String.format("Afiliado %s no existe", buscar.getId()));
        } else if (afiliado.get().getEstado() == 0) {
            throw new GeneralException(String.format("Afiliado %s no esta activo", buscar.getId()));
        }
        
        log.info("buscar tipo documento");
        Optional<TdcTipoDocumento> tipo = repositorioTipoDocumento.findById(buscar.getTipoDocumento().getId());
        if (tipo.isEmpty()) {
            throw new GeneralException(String.format("Tipo de documento %s no existe", buscar.getTipoDocumento().getId()));
        } else if (tipo.get().getEstado() == 0) {
            throw new GeneralException(String.format("Tipo de documento %s no esta activo", tipo.get().getId()));
        }
        
        repositorioAfiliado.save(Mapper.mapper(AfiAfiliado.class, buscar));
        log.info("Fin actualizar afiliado");
    }
}
