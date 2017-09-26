/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.FacturaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author je.bejarano10
 **/

/**
 * Clase que permite gestionar y validar las reglas de negocio
 * */

@Stateless
public class FacturaLogic {
  private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
  
       @Inject
       
       /**
        * Representa la asociación con la persistencia
        * */
       private FacturaPersistence persistence;
       
       /**
        * Método que permite crear y guardar una nueva factura
        * */
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
     /**
     * Obtener todas las Facturas existentes en la base de datos.
     *
     * @return una lista de Facturas.
     */
    public List<FacturaEntity> getFacturas() {
        LOGGER.info("Inicia proceso de consultar todas las Facturas");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<FacturaEntity> Facturas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Facturas");
        return Facturas;
    }

    /**
     *
     * Obtener una Factura por medio de su id.
     *
     * @param id: id de la Factura para ser buscada.
     * @return la Factura solicitada por medio de su id.
     **/
    public FacturaEntity getFactura(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Factura con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "find(id)" que se encuentra en la persistencia.
        FacturaEntity Factura= persistence.find(id);
        if (Factura == null) {
            LOGGER.log(Level.SEVERE, "La Factura con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Factura con id={0}", id);
        return Factura;
    }

    /**
     *
     * Actualizar una Factura.
     *
     * @param id: id de la Factura para buscarla en la base de datos.
     * @param entity: Factura con los cambios para ser actualizada, por
     * ejemplo el nombre.
     * @return la Factura con los cambios actualizados en la base de datos.
     */
    public FacturaEntity updateFactura(Long id,FacturaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Factura con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "update(entity)" que se encuentra en la persistencia.
        FacturaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Factura con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un Factura
     *
     * @param id: id de la Factura a borrar
     */
    public void deleteFactura(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Factura con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
            persistence.delete(id);

            LOGGER.log(Level.INFO, "Termina proceso de borrar Factura con id={0}", id);
        }
}
