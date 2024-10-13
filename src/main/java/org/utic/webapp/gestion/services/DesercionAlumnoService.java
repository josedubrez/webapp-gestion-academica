package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.DesercionAlumno;

import java.util.List;

@Local
public interface DesercionAlumnoService extends CrudService<DesercionAlumno>{
    List<Alumno> getAlumnoAll();
    List<Malla> getMallaAll();
}
