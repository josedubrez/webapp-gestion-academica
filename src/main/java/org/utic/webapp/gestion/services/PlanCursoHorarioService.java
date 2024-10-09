package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.DiaSemana;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface PlanCursoHorarioService extends CrudService<PlanCursoHorario>{
    List<DiaSemana> getDiasSemanaAll();
    List<Aula> getAulasAll();

    List<PlanCursoHorario> getPlanesCursosHorariosAllByPlanCurso(PlanCurso planCurso);
}
