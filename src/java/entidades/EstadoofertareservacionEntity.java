/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nestor2
 */
@Entity
@Table(name = "estadoofertareservacion")
@NamedQueries({
    @NamedQuery(name = "EstadoofertareservacionEntity.findAll", query = "SELECT e FROM EstadoofertareservacionEntity e")
    , @NamedQuery(name = "EstadoofertareservacionEntity.findByIdEstadoOfertaReservacion", query = "SELECT e FROM EstadoofertareservacionEntity e WHERE e.idEstadoOfertaReservacion = :idEstadoOfertaReservacion")
    , @NamedQuery(name = "EstadoofertareservacionEntity.findByEstado", query = "SELECT e FROM EstadoofertareservacionEntity e WHERE e.estado = :estado")})
public class EstadoofertareservacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idEstadoOfertaReservacion;
    @Basic(optional = false)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoOfertaReservacion")
    private List<OfertasEntity> ofertasEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoOfertaReservacion")
    private List<ReservacionEntity> reservacionEntityList;

    public EstadoofertareservacionEntity() {
    }

    public EstadoofertareservacionEntity(Integer idEstadoOfertaReservacion) {
        this.idEstadoOfertaReservacion = idEstadoOfertaReservacion;
    }

    public EstadoofertareservacionEntity(Integer idEstadoOfertaReservacion, String estado) {
        this.idEstadoOfertaReservacion = idEstadoOfertaReservacion;
        this.estado = estado;
    }

    public Integer getIdEstadoOfertaReservacion() {
        return idEstadoOfertaReservacion;
    }

    public void setIdEstadoOfertaReservacion(Integer idEstadoOfertaReservacion) {
        this.idEstadoOfertaReservacion = idEstadoOfertaReservacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<OfertasEntity> getOfertasEntityList() {
        return ofertasEntityList;
    }

    public void setOfertasEntityList(List<OfertasEntity> ofertasEntityList) {
        this.ofertasEntityList = ofertasEntityList;
    }

    public List<ReservacionEntity> getReservacionEntityList() {
        return reservacionEntityList;
    }

    public void setReservacionEntityList(List<ReservacionEntity> reservacionEntityList) {
        this.reservacionEntityList = reservacionEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOfertaReservacion != null ? idEstadoOfertaReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoofertareservacionEntity)) {
            return false;
        }
        EstadoofertareservacionEntity other = (EstadoofertareservacionEntity) object;
        if ((this.idEstadoOfertaReservacion == null && other.idEstadoOfertaReservacion != null) || (this.idEstadoOfertaReservacion != null && !this.idEstadoOfertaReservacion.equals(other.idEstadoOfertaReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EstadoofertareservacionEntity[ idEstadoOfertaReservacion=" + idEstadoOfertaReservacion + " ]";
    }
    
}
