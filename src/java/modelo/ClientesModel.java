package modelo;

import entidades.ClientesEntity;
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
public class ClientesModel {
    
    
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
     
      public ClientesEntity obtenerCliente(String idCliente) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
//Recupero el objeto desde la BD a través del método find
            ClientesEntity cliente = em.find(ClientesEntity.class,
                    idCliente);
            em.close();
            return cliente;
        } catch (Exception e) {
            em.close();
            return null;
        }
    }
      
      public int insertarCliente(ClientesEntity cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.persist(cliente);
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
      
       public int modificarCliente(ClientesEntity cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.merge(cliente);
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
       
        public int eliminarCliente(String cliente) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
//Recuperando el objeto a eliminar
            ClientesEntity est = em.find(ClientesEntity.class, cliente);
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
}
