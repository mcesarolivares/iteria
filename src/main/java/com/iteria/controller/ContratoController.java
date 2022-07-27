package com.iteria.controller;

import com.iteria.domain.EntityBase;
import com.iteria.domain.dto.CtoContratoDto;
import com.iteria.domain.interactors.ListarContratos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controladora de contrato.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ListarContratos listarContratos;
    
    /**
     * Listar contratos.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CtoContratoDto>> listar() {
        return ResponseEntity.ok().body(listarContratos.ejecutar(new EntityBase()));
    }
}
