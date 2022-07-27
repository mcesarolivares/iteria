package com.iteria.controller;

import com.iteria.controller.request.PlanRequest;
import com.iteria.domain.EntityBase;
import com.iteria.domain.adapters.Mapper;
import com.iteria.domain.dto.PlnPlanDto;
import com.iteria.domain.entity.GrabarPlanEntity;
import com.iteria.domain.interactors.GrabarPlan;
import com.iteria.domain.interactors.ListarPlan;

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
 * Controladora de plan.
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
@RequestMapping("/planes")
public class PlanController {

    @Autowired
    private ListarPlan listarPlan;
    
    @Autowired
    private GrabarPlan grabarPlan;
    
    /**
     * Listar planes.
     * @return
     */
    @GetMapping
    public ResponseEntity<List<PlnPlanDto>> listar() {
        return ResponseEntity.ok().body(listarPlan.ejecutar(new EntityBase()));
    }
    
    /**
     * Grabar planes.
     * @param request datos del plan
     * @return
     */
    @PostMapping
    public HttpStatus grabar(@Valid @RequestBody PlanRequest request) {
        grabarPlan.ejecutar(new GrabarPlanEntity(Mapper.mapper(PlnPlanDto.class, request)));
        return HttpStatus.CREATED;
    }
}
