/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
@Table(name = "transporte")
@NamedQueries({
    @NamedQuery(name = "TransporteEntity.findAll", query = "SELECT t FROM TransporteEntity t")
    , @NamedQuery(name = "TransporteEntity.findByIdTransporte", query = "SELECT t FROM TransporteEntity t WHERE t.idTransporte = :idTransporte")
    , @NamedQuery(name = "TransporteEntity.findByPlaca", query = "SELECT t FROM TransporteEntity t WHERE t.placa = :placa")
    , @NamedQuery(name = "TransporteEntity.findByMarca", query = "SELECT t FROM TransporteEntity t WHERE t.marca = :marca")
    , @NamedQuery(name = "TransporteEntity.findByModelo", query = "SELECT t FROM TransporteEntity t WHERE t.modelo = :modelo")
    , @NamedQuery(name = "TransporteEntity.findByColor", query = "SELECT t FROM TransporteEntity t WHERE t.color = :color")
    , @NamedQuery(name = "TransporteEntity.findByTipo", query = "SELECT t FROM TransporteEntity t WHERE t.tipo = :tipo")
    , @NamedQuery(name = "TransporteEntity.findByCapacidad", query = "SELECT t FROM TransporteEntity t WHERE t.capacidad = :capacidad")
    , @NamedQuery(name = "TransporteEntity.findByPrecio", query = "SELECT t FROM TransporteEntity t WHERE t.precio = :precio")
    , @NamedQuery(name = "TransporteEntity.findByFoto", query = "SELECT t FROM TransporteEntity t WHERE t.foto = :foto")})
public class TransporteEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idTransporte;
    @Basic(optional = false)
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private Integer capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal precio;
    private String foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransporte")
    private List<ServiciosEntity> serviciosEntityList;

    public TransporteEntity() {
    }

    public TransporteEntity(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public TransporteEntity(String idTransporte, String placa) {
        this.idTransporte = idTransporte;
        this.placa = placa;
    }

    public String getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransporteEntity)) {
            return false;
        }
        TransporteEntity other = (TransporteEntity) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TransporteEntity[ idTransporte=" + idTransporte + " ]";
    }
    
}
