/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Gio
 */
@Entity
@Table(name = "perfilempleados")
@NamedQueries({
    @NamedQuery(name = "PerfilempleadosEntity.findAll", query = "SELECT p FROM PerfilempleadosEntity p")
    , @NamedQuery(name = "PerfilempleadosEntity.findByIdPerfilEmpleados", query = "SELECT p FROM PerfilempleadosEntity p WHERE p.idPerfilEmpleados = :idPerfilEmpleados")
    , @NamedQuery(name = "PerfilempleadosEntity.findByPerfil", query = "SELECT p FROM PerfilempleadosEntity p WHERE p.perfil = :perfil")})
public class PerfilempleadosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPerfilEmpleados")
    private Integer idPerfilEmpleados;
    @Basic(optional = false)
    @Column(name = "perfil")
    private String perfil;

    public PerfilempleadosEntity() {
    }

    public PerfilempleadosEntity(Integer idPerfilEmpleados) {
        this.idPerfilEmpleados = idPerfilEmpleados;
    }

    public PerfilempleadosEntity(Integer idPerfilEmpleados, String perfil) {
        this.idPerfilEmpleados = idPerfilEmpleados;
        this.perfil = perfil;
    }

    public Integer getIdPerfilEmpleados() {
        return idPerfilEmpleados;
    }

    public void setIdPerfilEmpleados(Integer idPerfilEmpleados) {
        this.idPerfilEmpleados = idPerfilEmpleados;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilEmpleados != null ? idPerfilEmpleados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilempleadosEntity)) {
            return false;
        }
        PerfilempleadosEntity other = (PerfilempleadosEntity) object;
        if ((this.idPerfilEmpleados == null && other.idPerfilEmpleados != null) || (this.idPerfilEmpleados != null && !this.idPerfilEmpleados.equals(other.idPerfilEmpleados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PerfilempleadosEntity[ idPerfilEmpleados=" + idPerfilEmpleados + " ]";
    }
}
    

