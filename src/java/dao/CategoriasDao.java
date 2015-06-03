/*
 * Aplicación de ejemplo de uso de la tecnología JavaFX 2
 * Realizado para el Curso de Programación Java
 * Prof.: Ander 30 Oct 2014 - Desarrollado con fines unicamente didácticos. 
 */

package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import orm.Categorias;

/**
 *
 * @author ander
 */
@Stateless
public class CategoriasDao {

    @PersistenceContext
    EntityManager em;
    
    public List<Categorias> selectCategorias(){
         Query q = em.createQuery("Select c From Categorias c");
        return q.getResultList();
    }
    
    //Seleccionar Categorías para el combobox:
    public List<String> selectNombresCategorias(){
        Query q = em.createQuery("Select c.cat From Categorias c");
        return q.getResultList();
    }
    
    public Categorias selectCategoriaPorNombre(String nom){
        Query q = em.createQuery("Select c From Categorias c Where c.cat Like :nom");
        q.setParameter("nom", nom);
        return (Categorias) q.getSingleResult();
    }
}
