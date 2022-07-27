package com.iteria.controller.request;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Request plan.
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
public class PlanRequest {

    @Size(max = 4, message = "El id debe contener máximo 4 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String id;
    
    @NotEmpty
    @Size(max = 15, message = "El nombre debe contener máximo 15 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String nombre;
    
    @NotNull
    @FutureOrPresent
    private Date fechaInicio;
    
    @NotNull
    @Future
    private Date fechaFin;
    
    @NotEmpty
    @Pattern(regexp = "[1|0]*", message = "solo se permite 1 o 0")
    private String estado;
}
