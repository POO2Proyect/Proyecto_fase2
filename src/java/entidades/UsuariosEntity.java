/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "UsuariosEntity.findAll", query = "SELECT u FROM UsuariosEntity u")
    , @NamedQuery(name = "UsuariosEntity.findByIdUsuarios", query = "SELECT u FROM UsuariosEntity u WHERE u.idUsuarios = :idUsuarios")
    , @NamedQuery(name = "UsuariosEntity.findByUsuario", query = "SELECT u FROM UsuariosEntity u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "UsuariosEntity.findByPassword", query = "SELECT u FROM UsuariosEntity u WHERE u.password = :password")})
public class UsuariosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String idUsuarios;
    @Basic(optional = false)
    private String usuario;
    @Basic(optional = false)
    private String password;
    @JoinColumn(name = "idCliente", referencedColumnName = "idClientes")
    @ManyToOne(optional = false)
    private ClientesEntity idCliente;

    public UsuariosEntity() {
    }

    public UsuariosEntity(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public UsuariosEntity(String idUsuarios, String usuario, String password) {
        this.idUsuarios = idUsuarios;
        this.usuario = usuario;
        this.password = password;
    }

    public String getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(String idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientesEntity getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClientesEntity idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarios != null ? idUsuarios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosEntity)) {
            return false;
        }
        UsuariosEntity other = (UsuariosEntity) object;
        if ((this.idUsuarios == null && other.idUsuarios != null) || (this.idUsuarios != null && !this.idUsuarios.equals(other.idUsuarios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UsuariosEntity[ idUsuarios=" + idUsuarios + " ]";
    }
    
}
