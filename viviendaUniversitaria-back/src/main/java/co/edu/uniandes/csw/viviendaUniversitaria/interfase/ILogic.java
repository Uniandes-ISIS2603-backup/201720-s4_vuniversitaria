/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.interfase;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.List;

/**
 *
 * @author ws.duarte
 * @param <T>
 */
public interface ILogic<T extends BaseEntity> {

    public T create(T entity) throws BusinessLogicException;

    public T find(Long id)throws BusinessLogicException;

    public List<T> findAll()throws BusinessLogicException;

    public T update(T entity, Long id)throws BusinessLogicException;

    public void delete(Long id)throws BusinessLogicException;

}
