/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import orm.Gastos;

/**
 *
 * @author ander
 */
@Stateless
public class GastosDao {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager em;
    
    public List<Gastos> selectGastos(){
        Query q = em.createQuery("Select g From Gastos g");
        return q.getResultList();
    }
    
    public List<Gastos> selectGastos(String descripcion){
        Query q = em.createQuery("Select g From Gastos g WHERE g.gas LIKE :descripcion");
        q.setParameter("descripcion", "%" + descripcion + "%");
        return q.getResultList();
    }
    
    public List<Gastos> selectUltimosGastos(){
         Query q = em.createQuery("Select g From Gastos g Order By g.pkIdGas Desc");
         q.setMaxResults(5);
        return q.getResultList();
    }
    
    public BigDecimal selectTotalGastos(){
        Query q = em.createQuery("Select SUM(g.val) From Gastos g");
        
        return (BigDecimal)q.getSingleResult();
    }
    
    public Gastos selectGastoPorID(int id){
        Query q = em.createQuery("Select g From Gastos g Where g.pkIdGas = :id");
        q.setParameter("id", id);
        return (Gastos)q.getSingleResult();
    }
    
    /*
    *
    *  ABMs
    *
    */
    
    public void insertGasto(Gastos g){
        //em.getTransaction().begin();
        em.persist(g);
        //em.getTransaction().commit();
    }
    
    public void updateGasto(Gastos g){
        em.merge(g);
    }
    
    public void deleteGasto(Gastos g){
        em.remove(em.merge(g));
    }
    
}
