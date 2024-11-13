package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface ReemplazoDocenteService extends CrudService<ReemplazoDocente>{
    List<PlanCurso> getPlanCursoAll();
    List<Docente> getDocentesAll();
}
