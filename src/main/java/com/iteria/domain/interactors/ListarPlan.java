package com.iteria.domain.interactors;

import com.iteria.domain.EntityBase;
import com.iteria.domain.UseCase;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.PlnPlanDto;
import com.iteria.domain.repositorio.IRepositorioPlan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para listar plan.
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
public class ListarPlan extends UseCase<EntityBase, List<PlnPlanDto>> {

    @Autowired
    private IRepositorioPlan repositorioPlan;
    
    @Override
    protected List<PlnPlanDto> constructUseCase(EntityBase entity) {
        return Mapper.mapper(PlnPlanDto.class, repositorioPlan.findAll());
    }
}
