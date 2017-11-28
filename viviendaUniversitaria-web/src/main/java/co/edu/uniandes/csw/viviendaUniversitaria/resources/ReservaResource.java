 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.resources;

import co.edu.uniandes.csw.viviendaUniversitaria.dtos.EstudianteDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.HospedajeDetaillDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReservaDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.dtos.ReservaDetailDTO;
import co.edu.uniandes.csw.viviendaUniversitaria.ejb.ReservaLogic;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.ReservaEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author je.bejarano10
 */
@Path ("reservas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ReservaResource {
   
    private ReservaLogic reservaLogic;
      
    /**
     * Constructor por defecto
     */
    public ReservaResource(){
        //Constructor por defecto
    }
        
    /**
     * Constructor en el que se inicializa para acceder a la logica
     * @param reservaLogic 
     */
    @Inject
    public ReservaResource(ReservaLogic reservaLogic){
        this.reservaLogic = reservaLogic;
    }
    /**
     * Crea una nueva reserva asociandola a un hospedaje
     * @param reservaDetail
     * @return reserva hecha
     * @throws BusinessLogicException 
     */                   
    @POST
    public ReservaDetailDTO createReserva(ReservaDTO reservaDetail) throws BusinessLogicException {
        return new ReservaDetailDTO(reservaLogic.createReserva(reservaDetail.toEntity()));
    }
    
     @GET
    @Path("{id: \\d+}")
    public ReservaDetailDTO find(@PathParam("id") Long id) throws BusinessLogicException {
        ReservaEntity entity = reservaLogic.getReserva(id);
        if (entity == null) {
            throw new WebApplicationException("no existe" + id, 404);
        }
        return new ReservaDetailDTO(entity);
    }
    
    @GET
    public List<ReservaDetailDTO> finds() throws BusinessLogicException {
        return listReservaEntity2DTO(reservaLogic.getReservas());
    }
    
     private List<ReservaDetailDTO> listReservaEntity2DTO(List<ReservaEntity> entityList) {
        List<ReservaDetailDTO> list = new ArrayList<>();
        for (ReservaEntity entity : entityList) {
            list.add(new ReservaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Elimina una reserva de un hospedaje
     * @param id
     * @throws BusinessLogicException 
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        ReservaEntity entity = reservaLogic.getReserva(id);
        if (entity == null) {
            throw new WebApplicationException("la reserva no existe "+id, 404);
        }
        reservaLogic.deleteReserva(id);
    }  
    
    
    
    
    
    
    
    //ESTO FUE LO QUE HIZO JORGE, ESTA MAL TODO
//    
//    /*private List<DetalleReservaDetailDTO> detalleReservaListEntity2DTO(List<DetalleReservaEntity> entityList){
//        *  List<DetalleReservaDetailDTO> list = new ArrayList();
//        * for(DetalleReservaEntity entity : entityList){
//        *    list.add(new DetalleReservaDetailDTO(entity));
//        *}
//        *return list;
//    *}
//**/
//    private List<ReservaDetailDTO> reservaListEntity2DetailDTO(List<ReservaEntity> entityList){
//        List<ReservaDetailDTO> list = new ArrayList();
//        for(ReservaEntity entity : entityList){
//            list.add(new ReservaDetailDTO(entity));
//        }
//        return list;
//    }
//       
//    @GET
//    public List <ReservaDetailDTO> getReservas(){
//    List<ReservaEntity> reserva=reservaLogic.getReservas();
//     if (reserva == null) {
//            throw new WebApplicationException("No existan facturas", 404);
//        }
//    return reservaListEntity2DetailDTO(reservaLogic.getReservas());
//    }
//    
//    @GET 
//    @Path("{id: \\d+}")
//    public ReservaDetailDTO getReserva(@PathParam("id") Long id) throws BusinessLogicException {
//       ReservaEntity  entity = reservaLogic.getReserva(id);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
//        }
//        return new ReservaDetailDTO(entity);
//    }
//    @GET
//    @Path("{id: \\d+}/hospedaje")
//    public HospedajeDetaillDTO getHospedaje( @PathParam("id") Long id) throws BusinessLogicException {
//    ReservaEntity  entity = reservaLogic.getReserva(id);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
//        }
//        return new HospedajeDetaillDTO(entity.getHospedaje());
//    }
//    @GET
//    @Path("{id: \\d+}/estudiante")
//    public EstudianteDetailDTO getEstudiante( @PathParam("id") Long id) throws BusinessLogicException {
//        ReservaEntity  entity = reservaLogic.getReserva(id);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso " + id + " no existe.", 404);
//        }
//        return new EstudianteDetailDTO(entity.getEstudiante());
//    }
//    @POST
//    @Path("{idEstudiante: \\d+}/{idHospedaje: \\d+}")
//    public ReservaDetailDTO createReserva(@PathParam("idEstudiante")Long idEstudiante,@PathParam("idHospedaje") Long idHospedaje, ReservaDetailDTO reserva) throws BusinessLogicException {
//         ReservaEntity reservaEntity=reservaLogic.createReserva(reserva.toEntity());
//        reservaLogic.asociateReservaConHospedajeYEstudiante(idHospedaje, idEstudiante, reservaEntity);
//        return reserva;
//    }
//    @PUT
//    @Path("{id: \\d+}")
//    public ReservaDetailDTO updateReserva (@PathParam("id") Long id, ReservaDetailDTO reserva) throws BusinessLogicException {
//        reserva.setId(id);
//        ReservaEntity entity = reservaLogic.getReserva(id);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /books/" + id + " no existe.", 404);
//        }
//        return new ReservaDetailDTO(reservaLogic.updateReserva(id, reserva.toEntity()));
//    }
//    @DELETE
//    @Path("{id: \\d+}")
//    public void deleteReserva(@PathParam("id") Long id) throws BusinessLogicException {
//        ReservaEntity entity = reservaLogic.getReserva(id);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso /Reservas/" + id + " no existe.", 404);
//        }
//        reservaLogic.deleteReserva(id);
//    }
//    @Path("{id: \\d+}/detalleServicio")
//    public Class<DetalleServicioResourse> getDetalleServicioResource(@PathParam("id") Long id) {
//        ReservaEntity entity = reservaLogic.getReserva(id);
//        if (entity == null) {
//            throw new WebApplicationException("El recurso no existe.", 404);
//        }
//        return DetalleServicioResourse.class;
//    }
    
}
