package com.iteria.domain.interactors;

import com.iteria.data.TdcTipoDocumento;
import com.iteria.domain.UseCaseVoid;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.TdcTipoDocumentoDto;
import com.iteria.domain.entity.GrabarTipoDocumentoEntity;
import com.iteria.domain.repositorio.IRepositorioTipoDocumento;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para grabar tipo de documento.
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
public class GrabarTipoDocumento extends UseCaseVoid<GrabarTipoDocumentoEntity> {

    @Autowired
    private IRepositorioTipoDocumento repositorioTipoDocumento;
    
    @Override
    protected void constructUseCase(GrabarTipoDocumentoEntity entity) {
        log.info("Inicio grabar tipo de documento");
        TdcTipoDocumentoDto buscar = entity.getTipo();
        Optional<TdcTipoDocumento> tipo = repositorioTipoDocumento.findById(buscar.getId());
        if (tipo.isPresent()) {
            log.info("actualizar");
            TdcTipoDocumento actualizar = tipo.get();
            actualizar.setNombre(buscar.getNombre());
            actualizar.setEstado(buscar.getEstado());
            repositorioTipoDocumento.save(actualizar);
        } else {
            log.info("Nuevo");
            TdcTipoDocumento nuevo = Mapper.mapper(TdcTipoDocumento.class, buscar);
            nuevo.setEstado(1);
            repositorioTipoDocumento.save(nuevo);
        }
        
        log.info("Fin grabar tipo de documento");
    }
}
