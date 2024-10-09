package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface TrabajoPracticoService extends CrudService<TrabajoPractico>{
    List<TrabajoPractico> getAllByPlanCurso(PlanCurso planCurso);
}
