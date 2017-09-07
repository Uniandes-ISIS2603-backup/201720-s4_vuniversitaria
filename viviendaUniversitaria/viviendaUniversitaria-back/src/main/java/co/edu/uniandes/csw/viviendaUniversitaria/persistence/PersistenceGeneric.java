/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author NOA_WERMEID
 */
@Staleless
public class PersistenceGeneric<T>
{
    @PersistenceContext(unitName = "viviendaUniversitariaPU")
    protected EntityManager em;
    protected Class<T> clase;
    
    public PersistenceGeneric(Class<T> clase)
    {
        this.clase = clase;
    }
    
    public T agregar(T entidad)
    {
        em.persist(entidad);
        return entidad;
    }
    
    public T consultarID(Long id)
    {
        return em.find(clase, id);
    }
    
    public T actualizar(Long id)
    {
        return em.merge(consultarID(id));
    }
    
    public void eliminar(Long id)
    {
        em.remove(consultarID(id));
    }
    
    public List<T> consultatTodo(String tabla)
    {
        return em.createQuerty("select u from "+tabla+" u", clase).getResultList();
    }
    
}
