/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Nestor2
 */
@Entity
@Table(name = "ofertaservicio")
@NamedQueries({
    @NamedQuery(name = "OfertaservicioEntity.findAll", query = "SELECT o FROM OfertaservicioEntity o")
    , @NamedQuery(name = "OfertaservicioEntity.findByIdOfertaServicio", query = "SELECT o FROM OfertaservicioEntity o WHERE o.idOfertaServicio = :idOfertaServicio")})
public class OfertaservicioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idOfertaServicio;
    @JoinColumn(name = "idOferta", referencedColumnName = "idOfertas")
    @ManyToOne
    private OfertasEntity idOferta;
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicios")
    @ManyToOne
    private ServiciosEntity idServicio;

    public OfertaservicioEntity() {
    }

    public OfertaservicioEntity(Integer idOfertaServicio) {
        this.idOfertaServicio = idOfertaServicio;
    }

    public Integer getIdOfertaServicio() {
        return idOfertaServicio;
    }

    public void setIdOfertaServicio(Integer idOfertaServicio) {
        this.idOfertaServicio = idOfertaServicio;
    }

    public OfertasEntity getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(OfertasEntity idOferta) {
        this.idOferta = idOferta;
    }

    public ServiciosEntity getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(ServiciosEntity idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertaServicio != null ? idOfertaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaservicioEntity)) {
            return false;
        }
        OfertaservicioEntity other = (OfertaservicioEntity) object;
        if ((this.idOfertaServicio == null && other.idOfertaServicio != null) || (this.idOfertaServicio != null && !this.idOfertaServicio.equals(other.idOfertaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.OfertaservicioEntity[ idOfertaServicio=" + idOfertaServicio + " ]";
    }
    
}
