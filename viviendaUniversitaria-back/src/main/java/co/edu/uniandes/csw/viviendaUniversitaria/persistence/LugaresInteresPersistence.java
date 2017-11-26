/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.LugaresInteresEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juan Camilo Sanguino
 */
@Stateless
public class LugaresInteresPersistence extends GenericPresistence<LugaresInteresEntity>{

    /**
     * Constructor que llama al super de la clase
     */
    public  LugaresInteresPersistence()
    {
        super(LugaresInteresEntity.class);
    }
    
    public LugaresInteresEntity findForName (String name)
    {
        TypedQuery tq = em.createQuery("select a from LugaresInteresEntity a where a.name = :nombre ", LugaresInteresEntity.class);
        tq.setParameter("nombre", name);
        List<LugaresInteresEntity> respuesta = tq.getResultList();
        if(respuesta.isEmpty())
        {
            return null;
        }
        return respuesta.get(0);
    }
    
}
