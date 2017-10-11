/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
@Table(name = "usuariosempleados")
@NamedQueries({
    @NamedQuery(name = "UsuariosempleadosEntity.findAll", query = "SELECT u FROM UsuariosempleadosEntity u")
    , @NamedQuery(name = "UsuariosempleadosEntity.findByIdUsuariosEmpleados", query = "SELECT u FROM UsuariosempleadosEntity u WHERE u.idUsuariosEmpleados = :idUsuariosEmpleados")
    , @NamedQuery(name = "UsuariosempleadosEntity.findByUsuarioEmp", query = "SELECT u FROM UsuariosempleadosEntity u WHERE u.usuarioEmp = :usuarioEmp")
    , @NamedQuery(name = "UsuariosempleadosEntity.findByPasswordEmp", query = "SELECT u FROM UsuariosempleadosEntity u WHERE u.passwordEmp = :passwordEmp")
    , @NamedQuery(name = "UsuariosempleadosEntity.findByFechaCreacion", query = "SELECT u FROM UsuariosempleadosEntity u WHERE u.fechaCreacion = :fechaCreacion")})
public class UsuariosempleadosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idUsuariosEmpleados;
    @Basic(optional = false)
    private String usuarioEmp;
    @Basic(optional = false)
    private String passwordEmp;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private EmpleadoEntity idEmpleado;
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfilEmpleados")
    @ManyToOne(optional = false)
    private PerfilempleadosEntity idPerfil;

    public UsuariosempleadosEntity() {
    }

    public UsuariosempleadosEntity(String idUsuariosEmpleados) {
        this.idUsuariosEmpleados = idUsuariosEmpleados;
    }

    public UsuariosempleadosEntity(String idUsuariosEmpleados, String usuarioEmp, String passwordEmp) {
        this.idUsuariosEmpleados = idUsuariosEmpleados;
        this.usuarioEmp = usuarioEmp;
        this.passwordEmp = passwordEmp;
    }

    public String getIdUsuariosEmpleados() {
        return idUsuariosEmpleados;
    }

    public void setIdUsuariosEmpleados(String idUsuariosEmpleados) {
        this.idUsuariosEmpleados = idUsuariosEmpleados;
    }

    public String getUsuarioEmp() {
        return usuarioEmp;
    }

    public void setUsuarioEmp(String usuarioEmp) {
        this.usuarioEmp = usuarioEmp;
    }

    public String getPasswordEmp() {
        return passwordEmp;
    }

    public void setPasswordEmp(String passwordEmp) {
        this.passwordEmp = passwordEmp;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EmpleadoEntity getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(EmpleadoEntity idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public PerfilempleadosEntity getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(PerfilempleadosEntity idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuariosEmpleados != null ? idUsuariosEmpleados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosempleadosEntity)) {
            return false;
        }
        UsuariosempleadosEntity other = (UsuariosempleadosEntity) object;
        if ((this.idUsuariosEmpleados == null && other.idUsuariosEmpleados != null) || (this.idUsuariosEmpleados != null && !this.idUsuariosEmpleados.equals(other.idUsuariosEmpleados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UsuariosempleadosEntity[ idUsuariosEmpleados=" + idUsuariosEmpleados + " ]";
    }
    
}
