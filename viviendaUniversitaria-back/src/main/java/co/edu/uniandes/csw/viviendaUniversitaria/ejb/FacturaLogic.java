/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.FacturaPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author je.bejarano10
 **/
@Stateless
public class FacturaLogic {
  private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
       @Inject
       private FacturaPersistence persistence;
        public FacturaEntity createFactura( FacturaEntity entity) throws BusinessLogicException{
           LOGGER.info("Se inició el proceso para crear la factura");
           if(persistence.find(entity.getId())!=null){
               throw new BusinessLogicException("Ya existe una factura con ese id");
           }
           else{
               persistence.create(entity);
               LOGGER.info("Se creó la factura");
           }
           return entity;
       }
}
