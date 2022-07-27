package com.iteria.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia afiliado.
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
public class AfiAfiliadoDto {
    
    private String id;
    private String nombre;
    private String apellidos;
    private TdcTipoDocumentoDto tipoDocumento;
    private String documento;
    private String direccion;
    private String telefono;
    private String mail;
    private int estado;
}
