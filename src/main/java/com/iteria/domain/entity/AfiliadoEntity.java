package com.iteria.domain.entity;

import com.iteria.domain.EntityBase;
import com.iteria.domain.dto.AfiAfiliadoDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Objeto de negocio para dar de baja afiliado.
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
@AllArgsConstructor
public class AfiliadoEntity extends EntityBase {

    private final AfiAfiliadoDto afiliado;
}
