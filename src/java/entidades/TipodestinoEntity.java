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
@Table(name = "tipodestino")
@NamedQueries({
    @NamedQuery(name = "TipodestinoEntity.findAll", query = "SELECT t FROM TipodestinoEntity t")
    , @NamedQuery(name = "TipodestinoEntity.findByIdTipoDestino", query = "SELECT t FROM TipodestinoEntity t WHERE t.idTipoDestino = :idTipoDestino")
    , @NamedQuery(name = "TipodestinoEntity.findByNombre", query = "SELECT t FROM TipodestinoEntity t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipodestinoEntity.findByDireccion", query = "SELECT t FROM TipodestinoEntity t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "TipodestinoEntity.findByCaracteristicas", query = "SELECT t FROM TipodestinoEntity t WHERE t.caracteristicas = :caracteristicas")})
public class TipodestinoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoDestino;
    @Basic(optional = false)
    private String nombre;
    @Basic(optional = false)
    private String direccion;
    @Basic(optional = false)
    private String caracteristicas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDestino")
    private List<TourEntity> tourEntityList;

    public TipodestinoEntity() {
    }

    public TipodestinoEntity(Integer idTipoDestino) {
        this.idTipoDestino = idTipoDestino;
    }

    public TipodestinoEntity(Integer idTipoDestino, String nombre, String direccion, String caracteristicas) {
        this.idTipoDestino = idTipoDestino;
        this.nombre = nombre;
        this.direccion = direccion;
        this.caracteristicas = caracteristicas;
    }

    public Integer getIdTipoDestino() {
        return idTipoDestino;
    }

    public void setIdTipoDestino(Integer idTipoDestino) {
        this.idTipoDestino = idTipoDestino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<TourEntity> getTourEntityList() {
        return tourEntityList;
    }

    public void setTourEntityList(List<TourEntity> tourEntityList) {
        this.tourEntityList = tourEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDestino != null ? idTipoDestino.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipodestinoEntity)) {
            return false;
        }
        TipodestinoEntity other = (TipodestinoEntity) object;
        if ((this.idTipoDestino == null && other.idTipoDestino != null) || (this.idTipoDestino != null && !this.idTipoDestino.equals(other.idTipoDestino))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipodestinoEntity[ idTipoDestino=" + idTipoDestino + " ]";
    }
    
}
