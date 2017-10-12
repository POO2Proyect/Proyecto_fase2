package modelo;

import entidades.CabanasEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import utils.JpaUtil;

/**
 * @author Usuario
 */
public class CabanasModel {
    
    
    public List<CabanasEntity> listarCabanas(){
        //creamos una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query sql = em.createNamedQuery("CabanasEntity.findAll");
            //El método getResultList() de la clase Query permite obtener 
            // la lista de resultados de una consulta de selección
            List<CabanasEntity> lista = sql.getResultList();
            em.close();
            // Cerrando el EntityManager
            return lista;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public CabanasEntity obtenerCabanas(String idCabana){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            CabanasEntity cabanas = em.find(CabanasEntity.class, idCabana);
            em.close();
            return cabanas;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public int insertarCabana (CabanasEntity cabana){
        
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            //Iniciando transacción
            em.persist(cabana);
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
    
    public int modificarCabana (CabanasEntity cabana){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.merge(cabana);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return 0;
        }
    }
    
    public int eliminarCabana (String cabana){
        EntityManager em = JpaUtil.getEntityManager();
        int filasEliminadas = 0;
        try{
            //Recuperando el objeto a eliminar
            CabanasEntity est = em.find(CabanasEntity.class, cabana);
            if(est != null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(cabana);
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
