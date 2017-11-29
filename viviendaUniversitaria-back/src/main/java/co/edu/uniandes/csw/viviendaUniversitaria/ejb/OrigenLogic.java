/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.OrigenPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.eslava
 */
@Stateless
public class OrigenLogic extends GenericLogic<OrigenEntity> {
    private EstudianteLogic estudianteLogic;

    public OrigenLogic() {
        super();
    }

    @Inject
    public OrigenLogic(OrigenPersistence persistence, EstudianteLogic asd){
        super(persistence, OrigenEntity.class);
        this.estudianteLogic=asd;
    }
    /**
     * valida el JSON
     * @param entity
     * @return
     * @throws BusinessLogicException 
     */
    @Override
    public OrigenEntity create(OrigenEntity entity) throws BusinessLogicException {
        if(entity.getName() == null){
            throw new BusinessLogicException("faltan parametros en el JSon");
        }
        return super.create(entity);
    }
    /**
     * aqui creo la relacion Origen-Estudiante
     * @param cedula
     * @param idOrigen
     * @return
     * @throws BusinessLogicException 
     */
    public EstudianteEntity createEstudiante(Long cedula, Long idOrigen) throws BusinessLogicException {
        OrigenEntity origenEntity = find(idOrigen);
        EstudianteEntity estudianteEntity = estudianteLogic.find(cedula);
        if (estudianteEntity == null) {
            throw new BusinessLogicException("no existe el estudiante");
        }
        estudianteEntity.setOrigen(origenEntity);
        return estudianteEntity;
    }
/**
 * borra todos los estudiantes asociados a dicho origen
 * @param idOrigen
 * @throws BusinessLogicException 
 */
    public void removeEstudiantes(Long idOrigen) throws BusinessLogicException{
        List<EstudianteEntity> list = find(idOrigen).getEstudiantes();
        if (list.isEmpty()) {
            throw new BusinessLogicException("El recurso "+idOrigen+"/origen/" + "/no tiene estudiantes.");
        }
        list.clear();
    }
    
    
    /**
     * este es el get para un estudiante en la relacion Origen-Estudiante
     * @param origenId
     * @param id
     * @return
     * @throws BusinessLogicException 
     */
    public EstudianteEntity findEstudiantes(Long origenId, Long id) throws BusinessLogicException {
        List<EstudianteEntity> estudiantes = find(origenId).getEstudiantes();
        EstudianteEntity estudiante = estudianteLogic.find(id);
        int index = estudiantes.indexOf(estudiante);
        if (index >= 0) {
            return estudiantes.get(index);
        }
        throw new BusinessLogicException("El estudiante no está asociado al origen");

    }
    /**
     * Este es el getAll 
     * @param idOrigen
     * @return
     * @throws BusinessLogicException 
     */
    public List<EstudianteEntity> findAllEstudiantes(Long idOrigen) throws BusinessLogicException {
        return find(idOrigen).getEstudiantes();
    }
}
