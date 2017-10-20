package modelo;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import utils.JpaUtil;
import entidades.EstadoofertareservacionEntity;

/**
 *
 * @author Nestor2
 */
public class EstadoOfertaModel {
    
     public List<EstadoofertareservacionEntity> listarEstadOferta() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("EstadoofertareservacionEntity.findAll");
//El método getResultList() de la clase Query permite obtener 
// la lista de resultados de una consulta de selección
            List<EstadoofertareservacionEntity> lista = consulta.getResultList();
            em.close();
// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
     
      public EstadoofertareservacionEntity obtenerEstadOferta(int idEstado) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            //Recupero el objeto desde la BD a través del método find
           EstadoofertareservacionEntity idEs = em.find(EstadoofertareservacionEntity.class, idEstado);
            em.close();
            return idEs;
        } catch (Exception e) {
            em.close();
            return null;
        }

    
}
      
      public int insertarEstadoOferta(EstadoofertareservacionEntity estado) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.persist(estado);
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
      
      public int modificarEstadoOferta(EstadoofertareservacionEntity estado) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.merge(estado);
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
      
        public int eliminarEstadoOferta(int estado) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
            //Recuperando el objeto a eliminar
            EstadoofertareservacionEntity est = em.find(EstadoofertareservacionEntity.class, estado);
            if (est != null) {
                EntityTransaction tran = em.getTransaction();
                //Iniciando transacción
                tran.begin();
                //Borrando la instancia
                em.remove(est);
                //Confirmando la transacción
                tran.commit();
                filasBorradas = 1;
            }
            em.close();
            return filasBorradas;
        } catch (Exception e) {
            em.close();
            return 0;
        }
    }

}
