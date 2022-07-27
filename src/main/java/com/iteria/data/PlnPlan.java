package com.iteria.data;

import com.iteria.domain.SkipSerialize;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de relaci&oacute;n con base de datos de plan.
 * 
 * @author <b>Developer</b>: Cesar Olivares<br />
 *         <b>Cambios</b>:<br />
 *         <ul>
 *            <li>26-07-2022 - Creaci&oacute;n</li>
 *         </ul>
 * @version 1.0
 *
 */
@Entity
@Table(name = "PLAN", schema = "ITERIA")
@Getter
@Setter
@NoArgsConstructor
public class PlnPlan {

    @Id
    @Column(name = "PLN_ID", length = 4)
    private String id;
    
    @Column(name = "PLN_NOMBRE", length = 15)
    private String nombre;
    
    @Column(name = "PLN_FECHA_INICIO")
    private Date fechaInicio;
    
    @Column(name = "PLN_FECHA_FIN")
    private Date fechaFin;
    
    @Column(name = "PLN_ESTADO")
    private int estado;
    
    @SkipSerialize
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "plan")
    private List<CtoContrato> contratos; 
}
