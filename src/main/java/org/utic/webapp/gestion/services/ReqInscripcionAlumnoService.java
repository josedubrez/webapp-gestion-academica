package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface ReqInscripcionAlumnoService extends CrudService<ReqInscripcionAlumno>{
    List<Requisito> getRequisitoAll();
    List<Alumno> getAlumnoAll();

    List<ReqInscripcionAlumno> getAllByAlumno(Alumno alumno);
}
