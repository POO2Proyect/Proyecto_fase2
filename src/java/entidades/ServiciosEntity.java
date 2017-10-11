/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nestor2
 */
@Entity
@Table(name = "servicios")
@NamedQueries({
    @NamedQuery(name = "ServiciosEntity.findAll", query = "SELECT s FROM ServiciosEntity s")
    , @NamedQuery(name = "ServiciosEntity.findByIdServicios", query = "SELECT s FROM ServiciosEntity s WHERE s.idServicios = :idServicios")
    , @NamedQuery(name = "ServiciosEntity.findByNombre", query = "SELECT s FROM ServiciosEntity s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "ServiciosEntity.findByPrecio", query = "SELECT s FROM ServiciosEntity s WHERE s.precio = :precio")
    , @NamedQuery(name = "ServiciosEntity.findByHorario", query = "SELECT s FROM ServiciosEntity s WHERE s.horario = :horario")
    , @NamedQuery(name = "ServiciosEntity.findByDescripcion", query = "SELECT s FROM ServiciosEntity s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "ServiciosEntity.findByEstadoServicio", query = "SELECT s FROM ServiciosEntity s WHERE s.estadoServicio = :estadoServicio")})
public class ServiciosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idServicios;
    @Basic(optional = false)
    private String nombre;
    private String precio;
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    private String descripcion;
    @Basic(optional = false)
    private String estadoServicio;
    @OneToMany(mappedBy = "idServicio")
    private List<OfertaservicioEntity> ofertaservicioEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio")
    private List<ReservacionEntity> reservacionEntityList;
    @JoinColumn(name = "idCabanas", referencedColumnName = "idCabanas")
    @ManyToOne(optional = false)
    private CabanasEntity idCabanas;
    @JoinColumn(name = "idTour", referencedColumnName = "idTour")
    @ManyToOne(optional = false)
    private TourEntity idTour;
    @JoinColumn(name = "idTransporte", referencedColumnName = "idTransporte")
    @ManyToOne(optional = false)
    private TransporteEntity idTransporte;

    public ServiciosEntity() {
    }

    public ServiciosEntity(String idServicios) {
        this.idServicios = idServicios;
    }

    public ServiciosEntity(String idServicios, String nombre, String estadoServicio) {
        this.idServicios = idServicios;
        this.nombre = nombre;
        this.estadoServicio = estadoServicio;
    }

    public String getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(String idServicios) {
        this.idServicios = idServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public List<OfertaservicioEntity> getOfertaservicioEntityList() {
        return ofertaservicioEntityList;
    }

    public void setOfertaservicioEntityList(List<OfertaservicioEntity> ofertaservicioEntityList) {
        this.ofertaservicioEntityList = ofertaservicioEntityList;
    }

    public List<ReservacionEntity> getReservacionEntityList() {
        return reservacionEntityList;
    }

    public void setReservacionEntityList(List<ReservacionEntity> reservacionEntityList) {
        this.reservacionEntityList = reservacionEntityList;
    }

    public CabanasEntity getIdCabanas() {
        return idCabanas;
    }

    public void setIdCabanas(CabanasEntity idCabanas) {
        this.idCabanas = idCabanas;
    }

    public TourEntity getIdTour() {
        return idTour;
    }

    public void setIdTour(TourEntity idTour) {
        this.idTour = idTour;
    }

    public TransporteEntity getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(TransporteEntity idTransporte) {
        this.idTransporte = idTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicios != null ? idServicios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosEntity)) {
            return false;
        }
        ServiciosEntity other = (ServiciosEntity) object;
        if ((this.idServicios == null && other.idServicios != null) || (this.idServicios != null && !this.idServicios.equals(other.idServicios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ServiciosEntity[ idServicios=" + idServicios + " ]";
    }
    
}
