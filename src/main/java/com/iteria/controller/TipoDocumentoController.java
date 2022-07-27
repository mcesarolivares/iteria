package com.iteria.controller;

import com.iteria.controller.request.TipoDocumentoRequest;
import com.iteria.domain.EntityBase;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.TdcTipoDocumentoDto;
import com.iteria.domain.entity.GrabarTipoDocumentoEntity;
import com.iteria.domain.interactors.GrabarTipoDocumento;
import com.iteria.domain.interactors.ListarTipoDocumento;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controladora de tipo de documento.
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
@RequestMapping("/tipodocumentos")
public class TipoDocumentoController {

    @Autowired
    private ListarTipoDocumento listarTipoDocumento;
    
    @Autowired
    private GrabarTipoDocumento grabarTipoDocumento;
    
    /**
     * Listar tipo de documentos.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<TdcTipoDocumentoDto>> listar() {
        return ResponseEntity.ok().body(listarTipoDocumento.ejecutar(new EntityBase()));
    }
    
    /**
     * Grabar tipo de documento.
     * @param request datos de tipo
     * @return
     */
    @PostMapping
    public HttpStatus grabar(@Valid @RequestBody TipoDocumentoRequest request) {
        grabarTipoDocumento.ejecutar(new GrabarTipoDocumentoEntity(Mapper.mapper(TdcTipoDocumentoDto.class, request)));
        return HttpStatus.CREATED;
    }
}
