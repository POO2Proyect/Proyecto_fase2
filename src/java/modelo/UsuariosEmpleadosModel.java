/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import entidades.UsuariosempleadosEntity;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import utils.JpaUtil;
/**
 *
 * @author Usuario
 */
public class UsuariosEmpleadosModel {
    
    
     public List<UsuariosempleadosEntity> listarusuEmpleados() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("UsuariosempleadosEntity.findAll");
//El método getResultList() de la clase Query permite obtener 
// la lista de resultados de una consulta de selección
            List<UsuariosempleadosEntity> lista = consulta.getResultList();
            em.close();
// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
     
      public UsuariosempleadosEntity obtenerusuEmpleados(String idUsuarioEmpleados) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
//Recupero el objeto desde la BD a través del método find
            UsuariosempleadosEntity usuEmpleados = em.find(UsuariosempleadosEntity.class,
                    idUsuarioEmpleados);
            em.close();
            return usuEmpleados;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
      
      public int insertarusuEmpleados(UsuariosempleadosEntity usuEmpleado) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.persist(usuEmpleado);
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
      
       public int modificarusuEmpleados(UsuariosempleadosEntity usuEmpleados) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.merge(usuEmpleados);
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
       
        public int eliminarusuEmpleados(String usuEmpleados) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
//Recuperando el objeto a eliminar
            UsuariosempleadosEntity est = em.find(UsuariosempleadosEntity.class, usuEmpleados);
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


public boolean loginControl(String usuarioEmp,String passwordEmp){
  EntityManager em = JpaUtil.getEntityManager();
try {
Query Consulta = em.createNamedQuery("UsuariosempleadosEntity.control",UsuariosempleadosEntity.class).setParameter("usuarioEmp",usuarioEmp).setParameter("passwordEmp",usuarioEmp);
return Consulta.getResultList()!=null;
} catch (Exception e) {
return false;
}

}   
}
