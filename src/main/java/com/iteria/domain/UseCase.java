package com.iteria.domain;

import com.iteria.domain.exception.GeneralException;

/**
 * Clase base de los casos de uso.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
public abstract class UseCase<E extends EntityBase, T> {

    /**
     * Ejecuci&oacute;n de caso de uso.
     * @param entity objeto de negocio
     * @return objeto de respuesta del caso de uso
     */
    public T ejecutar(E entity) {
        if (entity == null) {
            throw new GeneralException("Debe agregar un objeto de negocio");
        }
        return constructUseCase(entity);
    }

    /**
     * Inicializador de casos de uso.
     * @param entity objeto de negocio
     * @return objeto de respuesta del caso de uso
     */
    protected abstract T constructUseCase(E entity);
}
