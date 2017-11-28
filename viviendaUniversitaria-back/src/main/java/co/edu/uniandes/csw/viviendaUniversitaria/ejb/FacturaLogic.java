/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.DetalleServicioEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.FacturaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.HospedajeEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ServiciosEntity;
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
 *
 */
/**
 * Clase que permite gestionar y validar las reglas de negocio
 *
 */
@Stateless
public class FacturaLogic {

    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
    /**
     *
     */
    @Inject
    private FacturaPersistence persistence;
    @Inject
    private EstudianteLogic estudianteLogic;
    @Inject
    private HospedajeLogic hospedajeLogic;
    @Inject
    private DetalleServicioLogic detalleServicioLog;

    /**
     * Método que permite crear y guardar una nueva factura
     *
     * @param entity
     * @param idHospedaje
     * @param cedulaEstudiante
     * @return
     * @throws BusinessLogicException
     */
    public FacturaEntity createFactura(FacturaEntity entity, Long idHospedaje, Long cedulaEstudiante) throws BusinessLogicException {
        LOGGER.info("Se inició el proceso para crear la factura");
        validarHospedajeYEstudiante(idHospedaje, cedulaEstudiante);
        HospedajeEntity hospedaje = hospedajeLogic.find(idHospedaje);
        EstudianteEntity estudiante = estudianteLogic.find(cedulaEstudiante);
        List<ServiciosEntity> serviciosOfrecidos = hospedaje.getServicios();
        double costoTotal = 0.0;
        for (ServiciosEntity serviciosOfrecido : serviciosOfrecidos) {
            DetalleServicioEntity nuevoDetalleServicio = new DetalleServicioEntity();
            nuevoDetalleServicio.setFactura(entity);
            nuevoDetalleServicio.setServicio(serviciosOfrecido);
            nuevoDetalleServicio.setSubTotal(serviciosOfrecido.getCosto());
            costoTotal += serviciosOfrecido.getCosto();   
        }
        entity.setTotal(costoTotal);
        entity.setHospedaje(hospedaje);
        entity.setEstudiante(estudiante);
        entity.setEstaPago(false);
        persistence.create(entity);
        LOGGER.info("Se creó la factura");

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
     * Obtener todas las Facturas existentes en la base de datos por idEstudiante.
     *
     * @param idEstudiante
     * @return una lista de Facturas.
     */
    public List<FacturaEntity> getFacturasIdEstudiante(Long idEstudiante) {
        LOGGER.info("Inicia proceso de consultar todas las Facturas por idEstudiante");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<FacturaEntity> Facturas = persistence.findIdEstudiante(idEstudiante);
        LOGGER.info("Termina proceso de consultar todas las Facturas por idEstudiante");
        return Facturas;
    }
        /**
     * Obtener todas las Facturas existentes en la base de datos.
     *
     * @param idHospedaje
     * @return una lista de Facturas.
     */
    public List<FacturaEntity> getFacturasIdHospedaje(Long idHospedaje) {
        LOGGER.info("Inicia proceso de consultar todas las Facturas por IdHospedaje");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<FacturaEntity> Facturas = persistence.findIdHospedaje(idHospedaje);
        LOGGER.info("Termina proceso de consultar todas las Facturas por idHospedaje");
        return Facturas;
    }

    /**
     *
     * Obtener una Factura por medio de su id.
     *
     * @param id: id de la Factura para ser buscada.
     * @return la Factura solicitada por medio de su id.
     * @throws co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     *
     */
    public FacturaEntity getFactura(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Factura con id={0}", id);
        FacturaEntity factura = validarExistenciaDelRecurso(id);
        LOGGER.log(Level.INFO, "Termina proceso de consultar Factura con id={0}", id);
        return factura;
    }
    /**
     *
     * Actualizar una Factura.
     *
     * @param id: id de la Factura para buscarla en la base de datos.
     * @param entity: Factura con los cambios para ser actualizada, por ejemplo
     * el nombre.
     * @return la Factura con los cambios actualizados en la base de datos.
     * @throws co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException
     */
    public FacturaEntity updateFactura(Long id, FacturaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Factura con id={0}", id);
        FacturaEntity old =validarExistenciaDelRecurso(id);
        if(old.isEstaPago()==false)
        {
            throw new BusinessLogicException("no puede modificar una factura que ya esta pagada");
        }
        entity.setId(id);
        entity.setDetalleServicio(old.getDetalleServicio());
        entity.setDetallesReserva(old.getDetallesReserva());
        entity.setEstudiante(old.getEstudiante());
        entity.setHospedaje(old.getHospedaje());
        if(entity.getIva()==0)
        {
            entity.setIva(old.getIva());
        }
        if(entity.getFecha()==null)
        {
            entity.setFecha(old.getFecha());
        }
        if(entity.getTotal()==0)
        {
            entity.setTotal(old.getTotal());
        }
        FacturaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Factura con id={0}", entity.getId());
        return newEntity;
    }
    /**
     * Borrar un Factura
     *
     * @param id: id de la Factura a borrar
     */
    public void deleteFactura(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Factura con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Factura con id={0}", id);
    }
    
    public void validarHospedajeYEstudiante(Long idHospedaje, Long cedulaEstudiante) throws BusinessLogicException {
        if (estudianteLogic.find(cedulaEstudiante) == null) {
            throw new BusinessLogicException("no existe un estudiante con esta cedula ");
        }
        if (hospedajeLogic.find(idHospedaje) == null) {
            throw new BusinessLogicException("No existe un hospedaje con este id ");
        }
    }
    public FacturaEntity validarExistenciaDelRecurso(Long id) throws BusinessLogicException
    {
        FacturaEntity factura = persistence.find(id);
        if (factura == null) {
            throw new BusinessLogicException("La Factura con el id " + id +" no existe");
        }
        return factura;
    }
}
