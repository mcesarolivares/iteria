package com.iteria.domain.entity;

import com.iteria.domain.EntityBase;
import com.iteria.domain.dto.PlnPlanDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de negocio para grabar plan.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class GrabarPlanEntity extends EntityBase {

    private final PlnPlanDto plan;
}
