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
@Table(name = "ofertas")
@NamedQueries({
    @NamedQuery(name = "OfertasEntity.findAll", query = "SELECT o FROM OfertasEntity o")
    , @NamedQuery(name = "OfertasEntity.findByIdOfertas", query = "SELECT o FROM OfertasEntity o WHERE o.idOfertas = :idOfertas")
    , @NamedQuery(name = "OfertasEntity.findByCodOferta", query = "SELECT o FROM OfertasEntity o WHERE o.codOferta = :codOferta")
    , @NamedQuery(name = "OfertasEntity.findByNombre", query = "SELECT o FROM OfertasEntity o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "OfertasEntity.findByFechaCreacion", query = "SELECT o FROM OfertasEntity o WHERE o.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "OfertasEntity.findByFechaVence", query = "SELECT o FROM OfertasEntity o WHERE o.fechaVence = :fechaVence")
    , @NamedQuery(name = "OfertasEntity.findByProcentaje", query = "SELECT o FROM OfertasEntity o WHERE o.procentaje = :procentaje")
    , @NamedQuery(name = "OfertasEntity.findByDescripcion", query = "SELECT o FROM OfertasEntity o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "OfertasEntity.findByIdOfertaServicio", query = "SELECT o FROM OfertasEntity o WHERE o.idOfertaServicio = :idOfertaServicio")})
public class OfertasEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idOfertas;
    private String codOferta;
    private String nombre;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    private Date fechaVence;
    private String procentaje;
    private String descripcion;
    @Basic(optional = false)
    private int idOfertaServicio;
    @JoinColumn(name = "idEstadoOfertaReservacion", referencedColumnName = "idEstadoOfertaReservacion")
    @ManyToOne(optional = false)
    private EstadoofertareservacionEntity idEstadoOfertaReservacion;
    @OneToMany(mappedBy = "idOferta")
    private List<OfertaservicioEntity> ofertaservicioEntityList;

    public OfertasEntity() {
    }

    public OfertasEntity(String idOfertas) {
        this.idOfertas = idOfertas;
    }

    public OfertasEntity(String idOfertas, int idOfertaServicio) {
        this.idOfertas = idOfertas;
        this.idOfertaServicio = idOfertaServicio;
    }

    public String getIdOfertas() {
        return idOfertas;
    }

    public void setIdOfertas(String idOfertas) {
        this.idOfertas = idOfertas;
    }

    public String getCodOferta() {
        return codOferta;
    }

    public void setCodOferta(String codOferta) {
        this.codOferta = codOferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public String getProcentaje() {
        return procentaje;
    }

    public void setProcentaje(String procentaje) {
        this.procentaje = procentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdOfertaServicio() {
        return idOfertaServicio;
    }

    public void setIdOfertaServicio(int idOfertaServicio) {
        this.idOfertaServicio = idOfertaServicio;
    }

    public EstadoofertareservacionEntity getIdEstadoOfertaReservacion() {
        return idEstadoOfertaReservacion;
    }

    public void setIdEstadoOfertaReservacion(EstadoofertareservacionEntity idEstadoOfertaReservacion) {
        this.idEstadoOfertaReservacion = idEstadoOfertaReservacion;
    }

    public List<OfertaservicioEntity> getOfertaservicioEntityList() {
        return ofertaservicioEntityList;
    }

    public void setOfertaservicioEntityList(List<OfertaservicioEntity> ofertaservicioEntityList) {
        this.ofertaservicioEntityList = ofertaservicioEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertas != null ? idOfertas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertasEntity)) {
            return false;
        }
        OfertasEntity other = (OfertasEntity) object;
        if ((this.idOfertas == null && other.idOfertas != null) || (this.idOfertas != null && !this.idOfertas.equals(other.idOfertas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.OfertasEntity[ idOfertas=" + idOfertas + " ]";
    }
    
}
