package com.iteria.controller;

import com.iteria.controller.request.ActualizarAfiliadoRequest;
import com.iteria.controller.request.AfiliadoRequest;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.AfiAfiliadoDto;
import com.iteria.domain.dto.PlnPlanDto;
import com.iteria.domain.dto.TdcTipoDocumentoDto;
import com.iteria.domain.entity.AfiliadoEntity;
import com.iteria.domain.entity.ListarAfiliadoEntity;
import com.iteria.domain.entity.RegistrarAfiliadoEntity;
import com.iteria.domain.interactors.ActualizarAfiliado;
import com.iteria.domain.interactors.DarBajaAfiliado;
import com.iteria.domain.interactors.ListarAfiliados;
import com.iteria.domain.interactors.RegistrarAfiliado;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de afiliado.
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
@RequestMapping("/afiliados")
public class AfiliadoController {

    @Autowired
    private ListarAfiliados listarAfiliados;
    
    @Autowired
    private RegistrarAfiliado registrarAfiliado;
    
    @Autowired
    private DarBajaAfiliado darBajaAfiliado;
    
    @Autowired
    private ActualizarAfiliado actualizarAfiliado;
    
    /**
     * Listar afiliados.
     * @param tipo tipo de documento
     * @return
     */
    @GetMapping
    public ResponseEntity<List<AfiAfiliadoDto>> listar(
            @RequestParam(value = "tipo", required = false) String tipo) {

        ListarAfiliadoEntity entity = new ListarAfiliadoEntity();
        entity.setTipoDocumento(tipo);
        return ResponseEntity.ok().body(listarAfiliados.ejecutar(entity));
    }
    
    /**
     * Registrar afiliado.
     * @param request
     * @return
     */
    @PostMapping
    public HttpStatus registrar(@Valid @RequestBody AfiliadoRequest request) {
        AfiAfiliadoDto afiliado = Mapper.mapper(AfiAfiliadoDto.class, request);
        TdcTipoDocumentoDto tipo = new TdcTipoDocumentoDto();
        tipo.setId(request.getTipo());
        afiliado.setTipoDocumento(tipo);
        
        PlnPlanDto plan = new PlnPlanDto();
        plan.setId(request.getPlan());
        
        RegistrarAfiliadoEntity entity = new RegistrarAfiliadoEntity(afiliado, plan);
        registrarAfiliado.ejecutar(entity);
        return HttpStatus.CREATED;
    }
    
    /**
     * Actualizar datos de afiliado.
     * @param request datos de afiliado
     * @return
     */
    @PutMapping
    public HttpStatus actualizar(@Valid @RequestBody ActualizarAfiliadoRequest request) {
        AfiAfiliadoDto afiliado = Mapper.mapper(AfiAfiliadoDto.class, request);
        TdcTipoDocumentoDto tipo = new TdcTipoDocumentoDto();
        tipo.setId(request.getTipo());
        afiliado.setTipoDocumento(tipo);
        AfiliadoEntity entity = new AfiliadoEntity(afiliado);
        actualizarAfiliado.ejecutar(entity);
        return HttpStatus.OK;
    }
    
    /**
     * Dar de baja afiliado.
     * @param id id de afiliado
     * @return
     */
    @DeleteMapping("/{id}")
    public HttpStatus baja(@PathVariable(value = "id") String id) {
        AfiAfiliadoDto afiliado = new AfiAfiliadoDto();
        afiliado.setId(id); 
        
        AfiliadoEntity entity = new AfiliadoEntity(afiliado);
        darBajaAfiliado.ejecutar(entity);
        return HttpStatus.OK;
    }
}
