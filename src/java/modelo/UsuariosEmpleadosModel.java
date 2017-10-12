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
