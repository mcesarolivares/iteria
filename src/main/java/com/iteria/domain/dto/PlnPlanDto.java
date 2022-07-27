package com.iteria.domain.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia plan.
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
public class PlnPlanDto {

    private String id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int estado;
}
