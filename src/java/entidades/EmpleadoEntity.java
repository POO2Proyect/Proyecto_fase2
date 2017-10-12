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
 * @author Usuario
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "EmpleadoEntity.findAll", query = "SELECT e FROM EmpleadoEntity e"),
    @NamedQuery(name = "EmpleadoEntity.findByIdEmpleado", query = "SELECT e FROM EmpleadoEntity e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "EmpleadoEntity.findByCodEmpleado", query = "SELECT e FROM EmpleadoEntity e WHERE e.codEmpleado = :codEmpleado"),
    @NamedQuery(name = "EmpleadoEntity.findByNombre", query = "SELECT e FROM EmpleadoEntity e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EmpleadoEntity.findByApellido", query = "SELECT e FROM EmpleadoEntity e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "EmpleadoEntity.findByEdad", query = "SELECT e FROM EmpleadoEntity e WHERE e.edad = :edad"),
    @NamedQuery(name = "EmpleadoEntity.findByCorreo", query = "SELECT e FROM EmpleadoEntity e WHERE e.correo = :correo"),
    @NamedQuery(name = "EmpleadoEntity.findByTelefono", query = "SELECT e FROM EmpleadoEntity e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "EmpleadoEntity.findByMovil", query = "SELECT e FROM EmpleadoEntity e WHERE e.movil = :movil"),
    @NamedQuery(name = "EmpleadoEntity.findByIdcargo", query = "SELECT e FROM EmpleadoEntity e WHERE e.idcargo = :idcargo"),
    @NamedQuery(name = "EmpleadoEntity.findByDireccion", query = "SELECT e FROM EmpleadoEntity e WHERE e.direccion = :direccion")})
public class EmpleadoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEmpleado")
    private String idEmpleado;
    @Basic(optional = false)
    @Column(name = "codEmpleado")
    private String codEmpleado;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "edad")
    private String edad;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "movil")
    private String movil;
    @Basic(optional = false)
    @Column(name = "idcargo")
    private String idcargo;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;

    public EmpleadoEntity() {
    }

    public EmpleadoEntity(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public EmpleadoEntity(String idEmpleado, String codEmpleado, String nombre, String apellido, String correo, String idcargo, String direccion) {
        this.idEmpleado = idEmpleado;
        this.codEmpleado = codEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.idcargo = idcargo;
        this.direccion = direccion;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoEntity)) {
            return false;
        }
        EmpleadoEntity other = (EmpleadoEntity) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EmpleadoEntity[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
