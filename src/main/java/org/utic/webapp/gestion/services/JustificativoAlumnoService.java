package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.JustificativoAlumno;

import java.util.List;

@Local
public interface JustificativoAlumnoService extends CrudService<JustificativoAlumno>{
    List<Alumno> getAlumnoAll();
}
