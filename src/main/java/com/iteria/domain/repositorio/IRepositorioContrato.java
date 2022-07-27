package com.iteria.domain.repositorio;

import com.iteria.data.CtoContrato;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * M&eacute;todos de modelado de datos de contrato.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
public interface IRepositorioContrato extends JpaRepository<CtoContrato, String> {

    @Query("select c from CtoContrato c where c.afiliado.id = :afiliado")
    List<CtoContrato> findByAfiliado(@Param("afiliado") String afiliado);
}
