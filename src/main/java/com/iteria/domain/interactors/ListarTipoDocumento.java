package com.iteria.domain.interactors;

import com.iteria.domain.EntityBase;
import com.iteria.domain.UseCase;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.TdcTipoDocumentoDto;
import com.iteria.domain.repositorio.IRepositorioTipoDocumento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para listar tipo de documentos.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
@Service
public class ListarTipoDocumento extends UseCase<EntityBase, List<TdcTipoDocumentoDto>> {

    @Autowired
    private IRepositorioTipoDocumento repositorioTipoDocumento;
    
    @Override
    protected List<TdcTipoDocumentoDto> constructUseCase(EntityBase entity) {
        return Mapper.mapper(TdcTipoDocumentoDto.class, repositorioTipoDocumento.findAll());
    }
}
