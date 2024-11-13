package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface InscripcionPlanCursoService extends CrudService<InscripcionPlanCurso>{
    List<PlanCurso> getPlanCursoAll();
    List<Alumno> getAlumnoAll();
    List<Docente> getDocenteAll();

    List<InscripcionPlanCurso> getAllByAlumno(Alumno alumno);
}
