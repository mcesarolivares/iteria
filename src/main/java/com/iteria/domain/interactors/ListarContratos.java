package com.iteria.domain.interactors;

import com.iteria.domain.EntityBase;
import com.iteria.domain.UseCase;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.CtoContratoDto;
import com.iteria.domain.repositorio.IRepositorioContrato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para listar contratos.
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
public class ListarContratos extends UseCase<EntityBase, List<CtoContratoDto>> {

    @Autowired
    private IRepositorioContrato repositorioContrato;
    
    @Override
    protected List<CtoContratoDto> constructUseCase(EntityBase entity) {
        return Mapper.mapper(CtoContratoDto.class, repositorioContrato.findAll());
    }
}
