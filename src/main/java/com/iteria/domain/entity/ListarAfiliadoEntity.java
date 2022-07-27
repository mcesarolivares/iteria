package com.iteria.domain.entity;

import com.iteria.domain.EntityBase;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de negocio para listar afiliados.
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
public class ListarAfiliadoEntity extends EntityBase {

    private String tipoDocumento;
}
