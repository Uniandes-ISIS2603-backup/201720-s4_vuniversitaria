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

    public EstudianteEntity createEstudiante(Long cedula, Long idOrigen) throws BusinessLogicException {
        OrigenEntity origenEntity = find(idOrigen);
        EstudianteEntity estudianteEntity = estudianteLogic.find(cedula);
        if (estudianteEntity == null) {
            throw new BusinessLogicException("no existe el estudiante");
        }
        estudianteEntity.setOrigen(origenEntity);
        return estudianteEntity;
    }

    public void removeEstudiante(Long id, Long idOrigen) throws BusinessLogicException{
        EstudianteEntity estuEntity = new EstudianteEntity();
        estuEntity.setId(id);
        List<EstudianteEntity> list = find(idOrigen).getEstudiantes();
        int i = list.indexOf(estuEntity);
        if (i < 0) {
            throw new BusinessLogicException("El recurso "+idOrigen+"/origen/" + id + "/Estudiante no existe.");
        }
        list.remove(estuEntity);
    }
    
    public EstudianteEntity findEstudiantes(Long origenId, Long id) throws BusinessLogicException {
        List<EstudianteEntity> estudiantes = find(origenId).getEstudiantes();
        EstudianteEntity estudiante = estudianteLogic.find(id);
        int index = estudiantes.indexOf(estudiante);
        if (index >= 0) {
            return estudiantes.get(index);
        }
        throw new BusinessLogicException("El estudiante no está asociado al origen");

    }

    public List<EstudianteEntity> findAllEstudiantes(Long idOrigen) throws BusinessLogicException {
        return find(idOrigen).getEstudiantes();
    }
}
