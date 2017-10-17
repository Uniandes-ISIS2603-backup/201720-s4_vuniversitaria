/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.viviendaUniversitaria.ejb;

import co.edu.uniandes.csw.viviendaUniversitaria.entities.CalificacionEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.EstudianteEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.entities.OrigenEntity;
import co.edu.uniandes.csw.viviendaUniversitaria.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viviendaUniversitaria.persistence.EstudiantePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ISIS2603
 */
@Stateless
public class EstudianteLogic extends GenericLogic<EstudianteEntity>{
    private CalificacionLogic calificacionLogic;
    
    public EstudianteLogic(){
        //asd       
    }
    @Inject
    public EstudianteLogic(EstudiantePersistence persistence, CalificacionLogic calificacionLogic) {
        super(persistence,EstudianteEntity.class);
        this.persistence = persistence;
        this.calificacionLogic = calificacionLogic;
    }
    public OrigenEntity getOrigen(Long cedula) throws BusinessLogicException {
        return find(cedula).getOrigen();
    }

    public CalificacionEntity addCalificacion(Long idCalificacion, Long idEstudiante) throws BusinessLogicException {
        EstudianteEntity estudianteEntity = find(idEstudiante);
        CalificacionEntity calificacionEntity = calificacionLogic.getCalificacion(idCalificacion);
        if (calificacionEntity == null) {
            throw new BusinessLogicException("no existe la calificacion");
        }
        calificacionEntity.setEstudiante(estudianteEntity);
        return calificacionEntity;
    }

    public CalificacionEntity getCalificacion(Long estudianteId, Long idCalificacion) throws BusinessLogicException {
        List<CalificacionEntity> calificaciones = find(estudianteId).getCalificaciones();
        CalificacionEntity calificacion = calificacionLogic.getCalificacion(idCalificacion);
        int index = calificaciones.indexOf(calificacion);
        if (index >= 0) {
            return calificaciones.get(index);
        }
        throw new BusinessLogicException("la calificacion no está asociada al estudiante");

    }

    public List<CalificacionEntity> getCalificaciones(Long idCalificacion) throws BusinessLogicException {
        return find(idCalificacion).getCalificaciones();
    }

    public List<CalificacionEntity> listCalificaciones(Long cedula) throws BusinessLogicException {
        return find(cedula).getCalificaciones();
    }

    public void removeCalificaciones(Long idCalificacion, Long cedula) throws BusinessLogicException {
        CalificacionEntity calificacionEntity = new CalificacionEntity();
        calificacionEntity.setId(idCalificacion);
        List<CalificacionEntity> list = find(cedula).getCalificaciones();
        int i = list.indexOf(calificacionEntity);
        if (i < 0) {
            throw new BusinessLogicException("El recurso /origen/" + idCalificacion + "/Estudiante no existe.");
        }
        list.remove(calificacionEntity);
    }
}
