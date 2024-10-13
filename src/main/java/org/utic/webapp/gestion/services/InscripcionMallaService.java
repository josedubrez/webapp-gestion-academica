package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface InscripcionMallaService extends CrudService<InscripcionMalla>{
    List<Malla> getMallasAll();
    List<Sede> getSedesAll();
    List<Turno> getTurnosAll();
    List<Alumno> getAlumnoAll();

    List<InscripcionMalla> getAllByAlumno(Alumno alumno);
}
