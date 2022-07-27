package com.iteria.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Captura de validaciones.
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
public class GeneralException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String mensaje;
}
