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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author a.eslava
 */
@Stateless
public class OrigenLogic extends GenericLogic<OrigenEntity>{

    private static final Logger LOGGER = Logger.getLogger(OrigenLogic.class.getName());

    private OrigenPersistence persistence;
    private EstudianteLogic estudianteLogic;

    public OrigenLogic() {
        super();
    }
    
    @Inject
    public OrigenLogic(OrigenPersistence persistence, EstudianteLogic estudianteLogic) {
        super(persistence, OrigenEntity.class);
        this.persistence = persistence;
        this.estudianteLogic = estudianteLogic;
    }

    
    
    public EstudianteEntity addEstudiante(Long cedula, Long idOrigen) throws BusinessLogicException {
        OrigenEntity origenEntity = find(idOrigen);
        EstudianteEntity estudianteEntity = estudianteLogic.getEstudiante(cedula);
        if (estudianteEntity == null) {
            throw new BusinessLogicException("no existe el estudiante");
        }
        estudianteEntity.setOrigen(origenEntity);
        return estudianteEntity;
    }


    public EstudianteEntity getEstudiante(Long origenId, Long cedula) throws BusinessLogicException {
        List<EstudianteEntity> estudiantes = find(origenId).getEstudiante();
        EstudianteEntity estudiante = estudianteLogic.getEstudiante(cedula);
        int index = estudiantes.indexOf(estudiante);
        if (index >= 0) {
            return estudiantes.get(index);
        }
        throw new BusinessLogicException("El estudiante no está asociado al origen");

    }

    public List<EstudianteEntity> getEstudiantes(Long idOrigen) throws BusinessLogicException {
        return find(idOrigen).getEstudiante();
    }

    
    public List<EstudianteEntity> listEstudiantes(Long idOrigen) throws BusinessLogicException {
        return find(idOrigen).getEstudiante();
    }

    public void removeEstudiante(Long cedula, Long idOrigen) throws BusinessLogicException{
        EstudianteEntity estuEntity = new EstudianteEntity();
        estuEntity.setCedula(cedula);
        List<EstudianteEntity> list = find(idOrigen).getEstudiante();
        int i = list.indexOf(estuEntity);
        if (i < 0) {
            throw new BusinessLogicException("El recurso /origen/" + cedula + "/Estudiante no existe.");
        }
        list.remove(estuEntity);
    }
}
