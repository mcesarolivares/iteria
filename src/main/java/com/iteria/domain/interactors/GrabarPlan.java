package com.iteria.domain.interactors;

import com.iteria.data.PlnPlan;
import com.iteria.domain.UseCaseVoid;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.PlnPlanDto;
import com.iteria.domain.entity.GrabarPlanEntity;
import com.iteria.domain.repositorio.IRepositorioPlan;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Caso de uso para grabar plan.
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
public class GrabarPlan extends UseCaseVoid<GrabarPlanEntity> {

    @Autowired
    private IRepositorioPlan repositorioPlan;
    
    @Override
    protected void constructUseCase(GrabarPlanEntity entity) {
        log.info("Inicio grabar plan");
        PlnPlanDto buscar = entity.getPlan();
        Optional<PlnPlan> plan = repositorioPlan.findById(buscar.getId());
        if (plan.isPresent()) {
            log.info("actualizar");
            PlnPlan act = Mapper.mapper(PlnPlan.class, buscar);
            repositorioPlan.save(act);
        } else {
            log.info("nuevo");
            PlnPlan nuevo = Mapper.mapper(PlnPlan.class, buscar);
            nuevo.setEstado(1);
            repositorioPlan.save(nuevo);
        }
        log.info("Fin grabar plan");
    }
}
