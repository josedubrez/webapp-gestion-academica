package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.SancionAlumno;

import java.util.List;

@Local
public interface SancionAlumnoService extends CrudService<SancionAlumno>{
    List<Alumno> getAlumnoAll();
    List<Malla> getMallaAll();
}
