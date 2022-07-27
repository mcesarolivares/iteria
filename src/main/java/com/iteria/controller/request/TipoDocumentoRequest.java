package com.iteria.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Request tipo de documento.
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
public class TipoDocumentoRequest {

    
    @Size(max = 2, message = "El id debe contener máximo 2 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String id;
    
    @NotEmpty
    @Size(max = 20, message = "El nombre debe contener máximo 20 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String nombre;
    
    @NotEmpty
    @Pattern(regexp = "[1|0]*", message = "solo se permite 1 o 0")
    private String estado;
}
