/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.interfase;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.BaseEntity;

/**
 *
 * @author ws.duarte
 * @param <T>
 */
public interface IDto<T extends BaseEntity>
{
    public T toEntity();
    
    /**
     * Recibe una entidad y construlle un dto
     * Funciona como el constructor
     * @param entity entidad
     * @return Dto con los valores de la entidad.
     */
    public IDto<T> setEntity(T entity);
}
