/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.FacturaPersistence;
import java.util.List;
import java.util.Objects;
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
       @Inject
       private EstudianteLogic estudianteLogic;
       @Inject
       private HospedajeLogic hospedajeLogic;
       
       
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
    public DetalleServicioEntity getDetalleServicio(Long idFactura, Long idDS){
        LOGGER.log(Level.INFO, "Inicia proceso de obtener el detalle servicio", idFactura);
        FacturaEntity factura=persistence.find(idFactura);
        List<DetalleServicioEntity> lista= factura.getDetalleServicio();
        
        for(DetalleServicioEntity detalle: lista){
            if(Objects.equals(detalle.getId(), idDS)){ //Se usa el equals porque es un Long
                LOGGER.log(Level.INFO, "Termina proceso de obtener el Detalle");
                return detalle;
            }
        }
        LOGGER.log(Level.INFO, "No se encontró ningún detalleServicio");
        return null;
        
        
    }
    
    public List<DetalleServicioEntity> getDetallesServicio(Long idFactura){
        LOGGER.log(Level.INFO, "Inicia proceso de obtener el detalle servicio", idFactura);
        FacturaEntity factura=persistence.find(idFactura);
        return factura.getDetalleServicio();
    }
    public DetalleReservaEntity getDetalleReserva(Long idFactura, Long idDS){
        LOGGER.log(Level.INFO, "Inicia proceso de obtener el detalle servicio", idFactura);
        FacturaEntity factura=persistence.find(idFactura);
        List<DetalleReservaEntity> lista= factura.getDetallesReserva();
        
        for(DetalleReservaEntity detalle: lista){
            if(Objects.equals(detalle.getId(), idDS)){ //Se usa el equals porque es un Long
                LOGGER.log(Level.INFO, "Termina proceso de obtener el Detalle");
                return detalle;
            }
        }
        LOGGER.log(Level.INFO, "No se encontró ningún DetalleReserva");
        return null;
        
        
    }
    public List<DetalleReservaEntity> getDetallesReserva(Long idFactura){
        LOGGER.log(Level.INFO, "Inicia proceso de obtener el detalle servicio", idFactura);
        FacturaEntity factura=persistence.find(idFactura);
        return factura.getDetallesReserva();
    }
    /**
     * Borrar un Factura
     *
     * @param id: id de la Factura a borrar
     */
    public void deleteFactura(Long id)  {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Factura con id={0}", id);
        // Note que, por medio de la inyección de dependencias se llama al método "delete(id)" que se encuentra en la persistencia.
            persistence.delete(id);

            LOGGER.log(Level.INFO, "Termina proceso de borrar Factura con id={0}", id);
        }
    public void deleteDetallesReserva(Long idFactura){
        FacturaEntity factura=persistence.find(idFactura);
        factura.setDetallesReserva(null);
        persistence.update(factura);
    }
    public void deleteDetalleReserva(Long idFactura, Long idDetalleReserva) throws BusinessLogicException{
        FacturaEntity factura=persistence.find(idFactura);
        List<DetalleReservaEntity> lista=factura.getDetallesReserva();
        for(DetalleReservaEntity detalleReserva: lista){
            if(Objects.equals(detalleReserva.getId(), idDetalleReserva)){ //Se compara con equals por ser un Long
                lista.remove(detalleReserva);
                factura.setDetallesReserva(lista);
                persistence.update(factura);
                return;
            }
        }
        throw new BusinessLogicException("Detalle reserva no existe");
    }
    public void deleteDetallesServicio(Long idFactura){
        FacturaEntity factura=persistence.find(idFactura);
        factura.setDetalleServicio(null);
        persistence.update(factura);
    }
    public void deleteDetalleServicio(Long idFactura, Long idDetalleServicio) throws BusinessLogicException{
        FacturaEntity factura=persistence.find(idFactura);
        List<DetalleServicioEntity> lista=factura.getDetalleServicio();
        for(DetalleServicioEntity DetalleServicio: lista){
            if(Objects.equals(DetalleServicio.getId(), idDetalleServicio)){ //Se compara con equals por ser un Long
                lista.remove(DetalleServicio);
                factura.setDetalleServicio(lista);
                persistence.update(factura);
                return;
            }
        }
        throw new BusinessLogicException("Detalle servicio no existe");
    }
  public HospedajeEntity getHospedaje(Long idFactura) throws BusinessLogicException{
      FacturaEntity factura=persistence.find(idFactura);
      if (factura==null){
          throw new BusinessLogicException("No se pudo encontrar una factura con ese id");
      }
      return factura.getHospedaje();
  }
  public HospedajeEntity setHospedaje(Long idFactura, HospedajeEntity hospedaje) throws BusinessLogicException{
      FacturaEntity factura=persistence.find(idFactura);
      if (factura==null){
          throw new BusinessLogicException("No se pudo encontrar una factura con ese id");
      }
      factura.setHospedaje(hospedaje);
      persistence.update(factura);
      return hospedaje;
  }
  public EstudianteEntity getEstudiante(Long idFactura) throws BusinessLogicException{
      FacturaEntity factura=persistence.find(idFactura);
      if (factura==null){
          throw new BusinessLogicException("No se pudo encontrar una factura con ese id");
      }
      return factura.getEstudiante();
  }
  public EstudianteEntity setEstudiante(Long idFactura, EstudianteEntity estudiante) throws BusinessLogicException{
      FacturaEntity factura=persistence.find(idFactura);
      if (factura==null){
          throw new BusinessLogicException("No se pudo encontrar una factura con ese id");
      }
      factura.setEstudiante(estudiante);
      persistence.update(factura);
      return estudiante;
}
   public void asociateFacturaConHospedajeYEstudiante (Long idHospedaje, Long idEstudiante, FacturaEntity factura) throws BusinessLogicException{
      EstudianteEntity estudiante= estudianteLogic.getEstudiante(idEstudiante);
      HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
      if(hospedaje==null || estudiante==null){
          throw new BusinessLogicException("Usuario u hospedaje inválido");
      }
      factura.setEstudiante(estudiante);
      factura.setHospedaje(hospedaje);
      persistence.update(factura);
      
       
   }
}
