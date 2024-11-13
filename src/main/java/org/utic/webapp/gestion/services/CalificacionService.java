package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Calificacion;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@Local
public interface CalificacionService extends CrudService<Calificacion>{
    List<Calificacion> getAllByPlanCurso(PlanCurso planCurso);
}
