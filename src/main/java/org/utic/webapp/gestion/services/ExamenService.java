package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@Local
public interface ExamenService extends CrudService<Examen>{
    List<Examen> getAllByPlanCurso(PlanCurso planCurso);
}
