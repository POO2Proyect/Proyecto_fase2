/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import utils.JpaUtil;
import entidades.OfertasEntity;
/**
 *
 * @author Nestor2
 */
public class OfertasModel {
    
    public List<OfertasEntity> listarOferta() {
//Obtengo una instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query consulta = em.createNamedQuery("OfertasEntity.findAll");
//El método getResultList() de la clase Query permite obtener 
// la lista de resultados de una consulta de selección
            List<OfertasEntity> lista = consulta.getResultList();
            em.close();
// Cerrando el EntityManager
            return lista;
        } catch (Exception e) {
            em.close();
            return null;
        }
}
    
    public OfertasEntity obtenerOferta(String idOferta) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
//Recupero el objeto desde la BD a través del método find
           OfertasEntity oferta = em.find(OfertasEntity.class,
                    idOferta);
            em.close();
            return oferta;
        } catch (Exception e) {
            em.close();
            return null;
        }
}
    
public int insertarOferta(OfertasEntity oferta) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.persist(oferta);
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
      
public int modificarOferta(OfertasEntity oferta) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        try {
            tran.begin();
//Iniciando transacción
            em.merge(oferta);
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

public int eliminarOferta(String oferta) {
        EntityManager em = JpaUtil.getEntityManager();
        int filasBorradas = 0;
        try {
//Recuperando el objeto a eliminar
            OfertasEntity est = em.find(OfertasEntity.class,oferta);
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
