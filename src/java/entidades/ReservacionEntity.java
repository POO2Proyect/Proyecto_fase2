/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nestor2
 */
@Entity
@Table(name = "reservacion")
@NamedQueries({
    @NamedQuery(name = "ReservacionEntity.findAll", query = "SELECT r FROM ReservacionEntity r")
    , @NamedQuery(name = "ReservacionEntity.findByIdReservacion", query = "SELECT r FROM ReservacionEntity r WHERE r.idReservacion = :idReservacion")
    , @NamedQuery(name = "ReservacionEntity.findByCodReservacion", query = "SELECT r FROM ReservacionEntity r WHERE r.codReservacion = :codReservacion")
    , @NamedQuery(name = "ReservacionEntity.findByValorAnticipo", query = "SELECT r FROM ReservacionEntity r WHERE r.valorAnticipo = :valorAnticipo")
    , @NamedQuery(name = "ReservacionEntity.findByProcentaje", query = "SELECT r FROM ReservacionEntity r WHERE r.procentaje = :procentaje")
    , @NamedQuery(name = "ReservacionEntity.findByFechaHoraReservacion", query = "SELECT r FROM ReservacionEntity r WHERE r.fechaHoraReservacion = :fechaHoraReservacion")
    , @NamedQuery(name = "ReservacionEntity.findByFechaHoraLlegada", query = "SELECT r FROM ReservacionEntity r WHERE r.fechaHoraLlegada = :fechaHoraLlegada")
    , @NamedQuery(name = "ReservacionEntity.findByFechaHoraIda", query = "SELECT r FROM ReservacionEntity r WHERE r.fechaHoraIda = :fechaHoraIda")})
public class ReservacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer idReservacion;
    @Basic(optional = false)
    private String codReservacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    private BigDecimal valorAnticipo;
    @Basic(optional = false)
    private String procentaje;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraReservacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraLlegada;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraIda;
    @JoinColumn(name = "idCliente", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private ClientesEntity idCliente;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private EmpleadoEntity idEmpleado;
    @JoinColumn(name = "idEstadoOfertaReservacion", referencedColumnName = "idEstadoOfertaReservacion")
    @ManyToOne(optional = false)
    private EstadoofertareservacionEntity idEstadoOfertaReservacion;
    @JoinColumn(name = "idServicio", referencedColumnName = "idServicios")
    @ManyToOne(optional = false)
    private ServiciosEntity idServicio;

    public ReservacionEntity() {
    }

    public ReservacionEntity(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public ReservacionEntity(Integer idReservacion, String codReservacion, BigDecimal valorAnticipo, String procentaje) {
        this.idReservacion = idReservacion;
        this.codReservacion = codReservacion;
        this.valorAnticipo = valorAnticipo;
        this.procentaje = procentaje;
    }

    public Integer getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.idReservacion = idReservacion;
    }

    public String getCodReservacion() {
        return codReservacion;
    }

    public void setCodReservacion(String codReservacion) {
        this.codReservacion = codReservacion;
    }

    public BigDecimal getValorAnticipo() {
        return valorAnticipo;
    }

    public void setValorAnticipo(BigDecimal valorAnticipo) {
        this.valorAnticipo = valorAnticipo;
    }

    public String getProcentaje() {
        return procentaje;
    }

    public void setProcentaje(String procentaje) {
        this.procentaje = procentaje;
    }

    public Date getFechaHoraReservacion() {
        return fechaHoraReservacion;
    }

    public void setFechaHoraReservacion(Date fechaHoraReservacion) {
        this.fechaHoraReservacion = fechaHoraReservacion;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public Date getFechaHoraIda() {
        return fechaHoraIda;
    }

    public void setFechaHoraIda(Date fechaHoraIda) {
        this.fechaHoraIda = fechaHoraIda;
    }

    public ClientesEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClientesEntity idCliente) {
        this.idCliente = idCliente;
    }

    public EmpleadoEntity getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(EmpleadoEntity idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public EstadoofertareservacionEntity getIdEstadoOfertaReservacion() {
        return idEstadoOfertaReservacion;
    }

    public void setIdEstadoOfertaReservacion(EstadoofertareservacionEntity idEstadoOfertaReservacion) {
        this.idEstadoOfertaReservacion = idEstadoOfertaReservacion;
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
        hash += (idReservacion != null ? idReservacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReservacionEntity)) {
            return false;
        }
        ReservacionEntity other = (ReservacionEntity) object;
        if ((this.idReservacion == null && other.idReservacion != null) || (this.idReservacion != null && !this.idReservacion.equals(other.idReservacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ReservacionEntity[ idReservacion=" + idReservacion + " ]";
    }
    
}
