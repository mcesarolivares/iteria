package com.iteria.data;

import com.iteria.domain.SkipSerialize;

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
 * Objeto de relaci&oacute;n con base de datos de tipo de documento.
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
@Table(name = "TIPO_DOCUMENTO", schema = "ITERIA")
@Getter
@Setter
@NoArgsConstructor
public class TdcTipoDocumento {

    @Id
    @Column(name = "TDC_ID", length = 2)
    private String id;
    
    @Column(name = "TDC_NOMBRE", length = 20)
    private String nombre;
    
    @Column(name = "TDC_ESTADO")
    private int estado;
    
    @SkipSerialize
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tipoDocumento")
    private List<AfiAfiliado> afiliados;
}
