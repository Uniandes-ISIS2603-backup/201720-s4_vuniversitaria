/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.interfase;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author ws.duarte
 * @param <T>
 */

public interface ILogic <T extends BaseEntity>
{
    public T create(T entity) throws WebApplicationException;
    public T find(Long id)throws WebApplicationException;
    public List<T> findAll()throws WebApplicationException;
    public T update(T entity, Long id)throws WebApplicationException;
    public void delete(Long id)throws WebApplicationException;
    
    
}
