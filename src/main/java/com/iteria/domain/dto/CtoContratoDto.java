package com.iteria.domain.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia de contrato.
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
public class CtoContratoDto {

    private String id;
    private AfiAfiliadoDto afiliado;
    private PlnPlanDto plan;
    private int cantidad;
    private Date fechaInicio;
    private Date fechaRetiro;
    private Date fechaRegistro;
    private String eps;
}
