/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.interfase;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author ws.duarte
 * @param <T>
 */
@Stateless
public interface IPersistence <T extends BaseEntity>
{
    public T create(T entity);
    public T find(Long id);
    public List<T> findAll();
    public T update(T entity);
    public void delete(Long id);
    public TypedQuery<T> execute(String sql);
    public Class<T> getClase();
}
