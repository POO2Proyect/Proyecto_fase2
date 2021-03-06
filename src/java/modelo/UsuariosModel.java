/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.ClientesEntity;
import entidades.UsuariosEntity;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import utils.JpaUtil;
/**
 *
 * @author Nestor2
 */
public class UsuariosModel {
    
    public List<UsuariosEntity> listarUsuarios() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsuariosEntity.findAll");
//El método getResultList() de la clase Query permite obtener 
// la lista de resultados de una consulta de selección
            List<UsuariosEntity> lista = consulta.getResultList();
            em.close();
// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
    
     public UsuariosEntity obtenerUsuario(String idUsuario) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
//Recupero el objeto desde la BD a través del método find
            UsuariosEntity usuario = em.find(UsuariosEntity.class,
                    idUsuario);
            em.close();
            return usuario;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
     
      public int insertarUsuario(UsuariosEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.persist(usuario);
//Guardando el objeto en la BD
            tran.commit();
//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
      public int modificarUsuarios(UsuariosEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.merge(usuario);
//Actualizando el objeto en la BD
            tran.commit();
//Confirmando la transacción
            em.close();
            return 1;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
      
    public int eliminarUsuarios(String usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
//Recuperando el objeto a eliminar
            UsuariosEntity est = em.find(UsuariosEntity.class,usuario);
            if (est != null) {
                EntityTransaction tran = em.getTransaction();
                tran.begin();
//Iniciando transacción
                em.remove(est);
//Borrando la instancia
                tran.commit();
//Confirmando la transacción
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }
    
    
    //llaves foraneas
    public List<ClientesEntity> listarClientes() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("ClientesEntity.findAll");
//El método getResultList() de la clase Query permite obtener 
// la lista de resultados de una consulta de selección
            List<ClientesEntity> lista = consulta.getResultList();
            em.close();
// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
    
    public boolean loginControl(String usuario, String password) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsuariosEntity.login");
            consulta.setParameter("usuario", usuario);
            consulta.setParameter("password", password);
             System.out.println(consulta);
            return !consulta.getResultList().isEmpty();
         
        } catch (Exception e) {
            return false;
        }
    }
}
