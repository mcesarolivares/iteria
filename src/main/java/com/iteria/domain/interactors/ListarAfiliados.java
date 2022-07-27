package com.iteria.domain.interactors;

import com.iteria.domain.UseCase;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.AfiAfiliadoDto;
import com.iteria.domain.entity.ListarAfiliadoEntity;
import com.iteria.domain.repositorio.IRepositorioAfiliado;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para listar afiliados.
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
public class ListarAfiliados extends UseCase<ListarAfiliadoEntity, List<AfiAfiliadoDto>> {

    @Autowired
    private IRepositorioAfiliado repositorioAfiliado;
    
    @Override
    protected List<AfiAfiliadoDto> constructUseCase(ListarAfiliadoEntity entity) {
        log.info("Inicio de listar afiliados");
        return Mapper.mapper(AfiAfiliadoDto.class, repositorioAfiliado.findAll());
    }
}
