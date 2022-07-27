package com.iteria.domain;

import com.iteria.domain.exception.GeneralException;

/**
 * Clase base de los casos de uso sin retorno de datos.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
public abstract class UseCaseVoid<E extends EntityBase> {

    /**
     * Ejecuci&oacute;n de caso de uso.
     * @param entity objeto de negocio
     */
    public void ejecutar(E entity) {
        if (entity == null) {
            throw new GeneralException("Debe agregar un objeto de negocio");
        }
        constructUseCase(entity);
    }

    /**
     * Inicializador de casos de uso.
     * @param entity objeto de negocio
     */
    protected abstract void constructUseCase(E entity);
}
