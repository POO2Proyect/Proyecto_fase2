/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.ClientesEntity;
import entidades.PerfilempleadosEntity;
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
public class PerfilesModel {
    
    public List<PerfilempleadosEntity> listarPerfiles() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("PerfilempleadosEntity.findAll");
//El método getResultList() de la clase Query permite obtener 
// la lista de resultados de una consulta de selección
            List<PerfilempleadosEntity> lista = consulta.getResultList();
            em.close();
// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
    
     public PerfilempleadosEntity obtenerPerfil(int idPerfilEmpleados) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
//Recupero el objeto desde la BD a través del método find
            PerfilempleadosEntity perfil = em.find(PerfilempleadosEntity.class,
                    idPerfilEmpleados);
            em.close();
            return perfil;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
     
      public int insertarPerfil(PerfilempleadosEntity perfil) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.persist(perfil);
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
      public int modificarPerfil(PerfilempleadosEntity perfil) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.merge(perfil);
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
      
    public int eliminarPerfil(String perfil) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
//Recuperando el objeto a eliminar
            PerfilempleadosEntity est = em.find(PerfilempleadosEntity.class,perfil);
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
//    public List<ClientesEntity> listarClientes() {
////Obtengo una instancia de EntityManager
//        EntityManager em = JpaUtil.getEntityManager();
//        try {
//            Query consulta = em.createNamedQuery("ClientesEntity.findAll");
////El método getResultList() de la clase Query permite obtener 
//// la lista de resultados de una consulta de selección
//            List<ClientesEntity> lista = consulta.getResultList();
//            em.close();
//// Cerrando el EntityManager
//            return lista;
//        } catch (Exception e) {
//            em.close();
//            return null;
//        }
//    }

    public List<PerfilempleadosEntity> listarPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
