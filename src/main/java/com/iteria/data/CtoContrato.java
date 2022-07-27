package com.iteria.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de relaci&oacute;n con base de datos de contrato.
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
@Table(name = "CONTRATO", schema = "ITERIA")
@Getter
@Setter
@NoArgsConstructor
public class CtoContrato {

    @Id
    @Column(name = "CTO_ID", length = 20)
    private String id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "AFI_ID")
    private AfiAfiliado afiliado;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PLN_ID")
    private PlnPlan plan;
    
    @Column(name = "CTO_CANTIDAD_USUARIOS")
    private int cantidad;
    
    @Column(name = "CTO_FECHA_INICIO")
    private Date fechaInicio;
    
    @Column(name = "CTO_FECHA_RETIRO")
    private Date fechaRetiro;
    
    @Column(name = "CTO_FECHA_REGISTRO")
    private Date fechaRegistro;
    
    @Column(name = "CTO_EPS", length = 20)
    private String eps;
}
