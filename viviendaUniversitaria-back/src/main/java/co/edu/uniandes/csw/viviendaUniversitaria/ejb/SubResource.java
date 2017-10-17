/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;


import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.GenericPresistence;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a.eslava
 * @param <R>
 * @param <S>
 */
public class SubResource<R extends BaseEntity, S extends BaseEntity> extends GenericLogic<S>{
    private GenericLogic<R> logic;
    private Function<R,List<S>> list;
    private BiConsumer<S,R> set;
    private Class<S> clase;

    public SubResource() {
        super();
    }
    
    public SubResource(GenericPresistence<S> persistence, GenericLogic<R> logic,Class<S> clase,final Function<R,List<S>> list,final BiConsumer<S,R> set) {
        this.persistence = persistence;
        this.clase=clase;
        this.logic = logic;
        this.list=list;
        this.set=set;
    }
    
    public List<S> findAll(long id) throws BusinessLogicException {
        return list.apply(logic.find(id));
    }
    
     public S find(long id,long idSub) throws BusinessLogicException {
        try {
            S s=clase.newInstance();
            s.setId(idSub);
            List<S> lista=findAll(id);
            for(S w:lista){
                System.out.println(w.getId());
            }
            int ind=lista.indexOf(s);
            System.out.println(s.getId()+"  :  "+ind);
            if(ind<0)
                throw new BusinessLogicException("no existe un subrecurso con id="+idSub+" en el recurso id="+id);
            return lista.get(ind);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(SubResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public S create(long id,S entity) throws BusinessLogicException {
        R r=logic.find(id);
        set.accept(entity, r);
        return create(entity);
    }
    
    public void remove(long idUsuario,long id) throws BusinessLogicException {
        S ent=find(idUsuario,id);
        findAll(id).remove(ent);
        delete(id);
    }
}