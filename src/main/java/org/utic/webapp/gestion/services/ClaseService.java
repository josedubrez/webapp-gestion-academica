package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@Local
public interface ClaseService extends CrudService<Clase>{
    List<Clase> getAllByPlanCurso(PlanCurso planCurso);
}
