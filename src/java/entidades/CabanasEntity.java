/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Nestor2
 */
@Entity
@Table(name = "cabanas")
@NamedQueries({
    @NamedQuery(name = "CabanasEntity.findAll", query = "SELECT c FROM CabanasEntity c")
    , @NamedQuery(name = "CabanasEntity.findByIdCabanas", query = "SELECT c FROM CabanasEntity c WHERE c.idCabanas = :idCabanas")
    , @NamedQuery(name = "CabanasEntity.findByCodCabana", query = "SELECT c FROM CabanasEntity c WHERE c.codCabana = :codCabana")
    , @NamedQuery(name = "CabanasEntity.findByNombre", query = "SELECT c FROM CabanasEntity c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CabanasEntity.findByNumLocal", query = "SELECT c FROM CabanasEntity c WHERE c.numLocal = :numLocal")
    , @NamedQuery(name = "CabanasEntity.findByCapacidad", query = "SELECT c FROM CabanasEntity c WHERE c.capacidad = :capacidad")
    , @NamedQuery(name = "CabanasEntity.findByPrecioDia", query = "SELECT c FROM CabanasEntity c WHERE c.precioDia = :precioDia")
    , @NamedQuery(name = "CabanasEntity.findByPrecioNoche", query = "SELECT c FROM CabanasEntity c WHERE c.precioNoche = :precioNoche")
    , @NamedQuery(name = "CabanasEntity.findByPrecioDN", query = "SELECT c FROM CabanasEntity c WHERE c.precioDN = :precioDN")
    , @NamedQuery(name = "CabanasEntity.findByDescripcion", query = "SELECT c FROM CabanasEntity c WHERE c.descripcion = :descripcion")})
public class CabanasEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCabanas")
    private String idCabanas;
    @Basic(optional = false)
    @Column(name = "codCabana")
    private String codCabana;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "numLocal")
    private Long numLocal;
    @Column(name = "capacidad")
    private Integer capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioDia")
    private BigDecimal precioDia;
    @Column(name = "precioNoche")
    private BigDecimal precioNoche;
    @Column(name = "precioDN")
    private BigDecimal precioDN;
    @Column(name = "descripcion")
    private String descripcion;

    public CabanasEntity() {
    }

    public CabanasEntity(String idCabanas) {
        this.idCabanas = idCabanas;
    }

    public CabanasEntity(String idCabanas, String codCabana, String nombre) {
        this.idCabanas = idCabanas;
        this.codCabana = codCabana;
        this.nombre = nombre;
    }

    public String getIdCabanas() {
        return idCabanas;
    }

    public void setIdCabanas(String idCabanas) {
        this.idCabanas = idCabanas;
    }

    public String getCodCabana() {
        return codCabana;
    }

    public void setCodCabana(String codCabana) {
        this.codCabana = codCabana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumLocal() {
        return numLocal;
    }

    public void setNumLocal(Long numLocal) {
        this.numLocal = numLocal;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(BigDecimal precioDia) {
        this.precioDia = precioDia;
    }

    public BigDecimal getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(BigDecimal precioNoche) {
        this.precioNoche = precioNoche;
    }

    public BigDecimal getPrecioDN() {
        return precioDN;
    }

    public void setPrecioDN(BigDecimal precioDN) {
        this.precioDN = precioDN;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCabanas != null ? idCabanas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabanasEntity)) {
            return false;
        }
        CabanasEntity other = (CabanasEntity) object;
        if ((this.idCabanas == null && other.idCabanas != null) || (this.idCabanas != null && !this.idCabanas.equals(other.idCabanas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CabanasEntity[ idCabanas=" + idCabanas + " ]";
    }
    
}
