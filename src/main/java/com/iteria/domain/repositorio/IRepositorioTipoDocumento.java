package com.iteria.domain.repositorio;

import com.iteria.data.TdcTipoDocumento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * M&eacute;todos de modelado de datos de tipo de documento.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
@Repository
public interface IRepositorioTipoDocumento extends JpaRepository<TdcTipoDocumento, String> {

}
