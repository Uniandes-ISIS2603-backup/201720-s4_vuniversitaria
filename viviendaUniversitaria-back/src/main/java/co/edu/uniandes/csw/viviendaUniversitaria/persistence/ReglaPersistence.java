/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.persistence;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.*;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 * Persistencia de la entidad regla.
 * @author NOA_WERMEID
 */
@Stateless
public class ReglaPersistence extends GenericPresistence<ReglaEntity> {

    /**
     * Construye el generico para la clase especificada.
     */
    public ReglaPersistence() {
        super(ReglaEntity.class);
    }
}
