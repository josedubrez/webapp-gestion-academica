package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface PlanCursoService extends CrudService<PlanCurso>{
    List<Sede> getSedesAll();
    List<Turno> getTurnosAll();
    List<Docente> getDocentesAll();
    List<MallaDet> getMallasDetAll();
}
