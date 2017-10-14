/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import utils.JpaUtil;
import entidades.ServiciosEntity;
/**
 *
 * @author Nestor2
 */
public class ServiciosModel {
    
    
     public List<ServiciosEntity> listarServicios(){
        //creamos una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query sql = em.createNamedQuery("TourEntity.findAll");
            //El método getResultList() de la clase Query permite obtener 
            // la lista de resultados de una consulta de selección
            List<ServiciosEntity> lista = sql.getResultList();
            em.close();
            // Cerrando el EntityManager
            return lista;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
     
     public ServiciosEntity obtenerServicio(String idServicio){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            ServiciosEntity servicios = em.find(ServiciosEntity.class, idServicio);
            em.close();
            return servicios;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
     
     public int insertarServicio (ServiciosEntity servicios){
        
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            //Iniciando transacción
            em.persist(servicios);
            //Guardando el objeto en la BD
            tran.commit();
            //Confirmando la transacción
            em.close();
            return 1;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return 0;
        }
    }
    
      public int modificarServicio(ServiciosEntity servicio){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.merge(servicio);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return 0;
        }
    }
      
      public int eliminarServicio(String servicio){
        EntityManager em = JpaUtil.getEntityManager();
        int filasEliminadas = 0;
        try{
            //Recuperando el objeto a eliminar
            ServiciosEntity est = em.find(ServiciosEntity.class,servicio);
            if(est != null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(servicio);
                tran.commit();
                filasEliminadas =1;
                em.close();
                return filasEliminadas;
            }
        }catch(Exception e){
            System.out.println(e);
            
        }
        em.close();
        return 0;
    }
    
    
}
