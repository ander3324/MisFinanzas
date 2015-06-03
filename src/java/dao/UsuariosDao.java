/*
 * Aplicación de ejemplo de uso de la tecnología JavaFX 2
 * Realizado para el Curso de Programación Java
 * Prof.: Ander 30 Oct 2014 - Desarrollado con fines unicamente didácticos. 
 */
package dao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import orm.Usuarios;

/**
 *
 * @author ander
 */

@Stateless
public class UsuariosDao {

    @PersistenceContext
    EntityManager em;

    public List<Usuarios> selectUsuarios() {
        Query q = em.createQuery("Select u From Usuarios u");
        return q.getResultList();
    }

    public List<Usuarios> selectUsuarioPorID(int id) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuarios u WHERE u.pkIdUsu = :pkIdUsu");
        q.setParameter("pkIdUsu", id);
        return q.getResultList();
    }
    
    public Usuarios selectUsuarioPorNombre(String nom) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuarios u WHERE u.usu Like :nom");
        q.setParameter("nom", nom);
        return (Usuarios)q.getSingleResult();
    }

    public Usuarios selectUnicoUsuario(int id) {
        Query q;
        q = em.createQuery("SELECT u FROM Usuarios u WHERE u.pkIdUsu = :pkIdUsu");
        q.setParameter("pkIdUsu", id);
        return (Usuarios)q.getSingleResult();
    }
    
    public List<String> selectSoloNombres(){
         Query q = em.createQuery("Select u.usu From Usuarios u");
        return q.getResultList();
    }
    
    public int selectIdPorNombre(String nom){
        Query q = em.createQuery("Select u.pkIdUsu From Usuarios u Where u.usu Like :nom");
        q.setParameter("nom", nom);
        return q.getFirstResult();
    }

    public void insertUsuario(Usuarios usu) {
        em.persist(usu);
    }

    public void updateUsuario(Usuarios usu) {
        em.merge(usu);
    }

    public void deleteUsuario(Usuarios usu) {
        em.remove(em.merge(usu));
    }

}
