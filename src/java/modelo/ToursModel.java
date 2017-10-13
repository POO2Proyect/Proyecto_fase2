package modelo;

import entidades.TourEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import utils.JpaUtil;

/**
 * @author Usuario
 */
public class ToursModel {
     public List<TourEntity> listarTours(){
        //creamos una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query sql = em.createNamedQuery("TourEntity.findAll");
            //El método getResultList() de la clase Query permite obtener 
            // la lista de resultados de una consulta de selección
            List<TourEntity> lista = sql.getResultList();
            em.close();
            // Cerrando el EntityManager
            return lista;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public TourEntity obtenerTour(String idTour){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            TourEntity cabanas = em.find(TourEntity.class, idTour);
            em.close();
            return cabanas;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public int insertarTours (TourEntity tour){
        
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            //Iniciando transacción
            em.persist(tour);
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
    
    public int modificarTours(TourEntity tour){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.merge(tour);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return 0;
        }
    }
    
    public int eliminarTours(String tour){
        EntityManager em = JpaUtil.getEntityManager();
        int filasEliminadas = 0;
        try{
            //Recuperando el objeto a eliminar
            TourEntity est = em.find(TourEntity.class, tour);
            if(est != null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(tour);
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
