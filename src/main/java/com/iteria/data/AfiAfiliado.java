package com.iteria.data;

import com.iteria.domain.SkipSerialize;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objeto de relaci&oacute;n con base de datos de afiliado.
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
@Table(name = "AFILIADO", schema = "ITERIA")
@Getter
@Setter
@NoArgsConstructor
public class AfiAfiliado {
    
    @Id
    @Column(name = "AFI_ID", length = 10)
    private String id;
    
    @Column(name = "AFI_NOMBRE", length = 20)
    private String nombre;
    
    @Column(name = "AFI_APELLIDOS", length = 30)
    private String apellidos;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TDC_ID")
    private TdcTipoDocumento tipoDocumento;
    
    @Column(name = "AFI_DOCUMENTO", length = 20)
    private String documento;
    
    @Column(name = "AFI_DIRECCION", length = 30)
    private String direccion;
    
    @Column(name = "AFI_TELEFONO", length = 20)
    private String telefono;
    
    @Column(name = "AFI_MAIL", length = 30)
    private String mail;
    
    @Column(name = "AFI_ESTADO")
    private int estado;
    
    @SkipSerialize
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "afiliado")
    private List<CtoContrato> contratos; 
}
