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
 * @author Nestor2
 */
@Entity
@Table(name = "clientes")
@NamedQueries({
    @NamedQuery(name = "ClientesEntity.findAll", query = "SELECT c FROM ClientesEntity c")
    , @NamedQuery(name = "ClientesEntity.findByIdClientes", query = "SELECT c FROM ClientesEntity c WHERE c.idClientes = :idClientes")
    , @NamedQuery(name = "ClientesEntity.findByDui", query = "SELECT c FROM ClientesEntity c WHERE c.dui = :dui")
    , @NamedQuery(name = "ClientesEntity.findByNombre", query = "SELECT c FROM ClientesEntity c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "ClientesEntity.findByApellido", query = "SELECT c FROM ClientesEntity c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "ClientesEntity.findByTelefono", query = "SELECT c FROM ClientesEntity c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "ClientesEntity.findByMovil", query = "SELECT c FROM ClientesEntity c WHERE c.movil = :movil")
    , @NamedQuery(name = "ClientesEntity.findByEdad", query = "SELECT c FROM ClientesEntity c WHERE c.edad = :edad")
    , @NamedQuery(name = "ClientesEntity.findByCorreo", query = "SELECT c FROM ClientesEntity c WHERE c.correo = :correo")
    , @NamedQuery(name = "ClientesEntity.findByDireccion", query = "SELECT c FROM ClientesEntity c WHERE c.direccion = :direccion")})
public class ClientesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idClientes")
    private String idClientes;
    @Basic(optional = false)
    @Column(name = "dui")
    private String dui;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "movil")
    private String movil;
    @Column(name = "edad")
    private String edad;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;

    public ClientesEntity() {
    }

    public ClientesEntity(String idClientes) {
        this.idClientes = idClientes;
    }

    public ClientesEntity(String idClientes, String dui, String nombre, String apellido, String telefono, String movil, String correo, String direccion) {
        this.idClientes = idClientes;
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.movil = movil;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(String idClientes) {
        this.idClientes = idClientes;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientes != null ? idClientes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientesEntity)) {
            return false;
        }
        ClientesEntity other = (ClientesEntity) object;
        if ((this.idClientes == null && other.idClientes != null) || (this.idClientes != null && !this.idClientes.equals(other.idClientes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.ClientesEntity[ idClientes=" + idClientes + " ]";
    }
    
}
