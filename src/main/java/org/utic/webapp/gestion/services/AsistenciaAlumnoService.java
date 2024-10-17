package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface AsistenciaAlumnoService extends CrudService<AsistenciaAlumno>{
    List<AsistenciaAlumno> getAllByClase(Clase clase);
    List<AsistenciaAlumno> getAllByDocente(Docente docente);
}
