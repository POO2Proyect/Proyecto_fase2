
package modelo;

import entidades.TipodestinoEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import utils.JpaUtil;

/**
 *
 * @author Usuario
 */
public class TipoDestinoModel {
    
     public List<TipodestinoEntity> listarTipoDestino(){
        //creamos una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try{
            Query sql = em.createNamedQuery("TipodestinoEntity.findAll");
            //El método getResultList() de la clase Query permite obtener 
            // la lista de resultados de una consulta de selección
            List<TipodestinoEntity> lista = sql.getResultList();
            em.close();
            // Cerrando el EntityManager
            return lista;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public TipodestinoEntity obtenerDestino(int idDestino){
        EntityManager em = JpaUtil.getEntityManager();
        try{
            TipodestinoEntity destino = em.find(TipodestinoEntity.class, idDestino);
            em.close();
            return destino;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return null;
        }
        
    }
    
    public int insertarDestino(TipodestinoEntity destino){
        
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            //Iniciando transacción
            em.persist(destino);
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
    
    public int modificarDestino(TipodestinoEntity destino){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try{
            tran.begin();
            em.merge(destino);
            tran.commit();
            em.close();
            return 1;
        }catch(Exception e){
            System.out.println(e);
            em.close();
            return 0;
        }
    }
    
    public int eliminarDestino(int destino){
        EntityManager em = JpaUtil.getEntityManager();
        int filasEliminadas = 0;
        try{
            //Recuperando el objeto a eliminar
            TipodestinoEntity est = em.find(TipodestinoEntity.class, destino);
            if(est != null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(destino);
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

    public TipodestinoEntity obtenerDestino(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
