package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.DistribucionEscala;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@Local
public interface DistribucionEscalaService extends CrudService<DistribucionEscala>{
    List<DistribucionEscala> getAllByPlanCurso(PlanCurso planCurso);
}
