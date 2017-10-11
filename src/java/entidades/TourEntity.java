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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Nestor2
 */
@Entity
@Table(name = "tour")
@NamedQueries({
    @NamedQuery(name = "TourEntity.findAll", query = "SELECT t FROM TourEntity t")
    , @NamedQuery(name = "TourEntity.findByIdTour", query = "SELECT t FROM TourEntity t WHERE t.idTour = :idTour")
    , @NamedQuery(name = "TourEntity.findByCodTour", query = "SELECT t FROM TourEntity t WHERE t.codTour = :codTour")
    , @NamedQuery(name = "TourEntity.findByNombre", query = "SELECT t FROM TourEntity t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TourEntity.findByPrecioUni", query = "SELECT t FROM TourEntity t WHERE t.precioUni = :precioUni")
    , @NamedQuery(name = "TourEntity.findByDuracion", query = "SELECT t FROM TourEntity t WHERE t.duracion = :duracion")
    , @NamedQuery(name = "TourEntity.findByDescripcion", query = "SELECT t FROM TourEntity t WHERE t.descripcion = :descripcion")})
public class TourEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idTour;
    @Basic(optional = false)
    private String codTour;
    private String nombre;
    private String precioUni;
    private String duracion;
    private String descripcion;
    @JoinColumn(name = "idDestino", referencedColumnName = "idTipoDestino")
    @ManyToOne(optional = false)
    private TipodestinoEntity idDestino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTour")
    private List<ServiciosEntity> serviciosEntityList;

    public TourEntity() {
    }

    public TourEntity(String idTour) {
        this.idTour = idTour;
    }

    public TourEntity(String idTour, String codTour) {
        this.idTour = idTour;
        this.codTour = codTour;
    }

    public String getIdTour() {
        return idTour;
    }

    public void setIdTour(String idTour) {
        this.idTour = idTour;
    }

    public String getCodTour() {
        return codTour;
    }

    public void setCodTour(String codTour) {
        this.codTour = codTour;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(String precioUni) {
        this.precioUni = precioUni;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipodestinoEntity getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(TipodestinoEntity idDestino) {
        this.idDestino = idDestino;
    }

    public List<ServiciosEntity> getServiciosEntityList() {
        return serviciosEntityList;
    }

    public void setServiciosEntityList(List<ServiciosEntity> serviciosEntityList) {
        this.serviciosEntityList = serviciosEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTour != null ? idTour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TourEntity)) {
            return false;
        }
        TourEntity other = (TourEntity) object;
        if ((this.idTour == null && other.idTour != null) || (this.idTour != null && !this.idTour.equals(other.idTour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TourEntity[ idTour=" + idTour + " ]";
    }
    
}
