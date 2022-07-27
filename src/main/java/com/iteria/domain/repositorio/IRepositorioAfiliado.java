package com.iteria.domain.repositorio;

import com.iteria.data.AfiAfiliado;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * M&eacute;todos de modelado de datos de afiliado.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
public interface IRepositorioAfiliado extends JpaRepository<AfiAfiliado, String> {

}
