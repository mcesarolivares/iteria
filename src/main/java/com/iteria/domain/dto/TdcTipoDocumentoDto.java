package com.iteria.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Objeto de transferencia tipo de documento.
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
public class TdcTipoDocumentoDto {

    private String id;
    private String nombre;
    private int estado;
}
