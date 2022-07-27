package com.iteria.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Request de afiliado.
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
public class AfiliadoRequest {
    
    @NotEmpty
    @Size(max = 10, message = "El id debe contener máximo 10 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String id;
    
    @NotEmpty
    @Size(max = 20, message = "El nombre debe contener máximo 20 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String nombre;
    
    @NotEmpty
    @Size(max = 30, message = "Los apellidos debe contener máximo 30 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String apellidos;
    
    @NotEmpty
    @Size(max = 2, message = "El tipo de documento debe contener máximo 2 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String tipo;
    
    @NotEmpty
    @Size(max = 4, message = "El plan debe contener máximo 4 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String plan;
    
    @NotEmpty
    @Size(max = 20, message = "El documento debe contener máximo 20 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String documento;
    
    @NotEmpty
    @Size(max = 30, message = "La dirección debe contener máximo 30 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String direccion;
    
    @NotEmpty
    @Size(max = 20, message = "El teléfono debe contener máximo 20 caracteres")
    @Pattern(regexp = "[A-Za-z0-9\\s]*", message = "No se permite caracteres extraños")
    private String telefono;
    
    @NotEmpty
    @Size(max = 30, message = "El correo debe contener máximo 30 caracteres")
    @Email
    private String mail;
}
