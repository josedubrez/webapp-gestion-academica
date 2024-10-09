package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Aula;
import org.utic.webapp.gestion.entities.DiaSemana;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.entities.PlanCursoHorario;
import org.utic.webapp.gestion.repositories.AulaRepository;
import org.utic.webapp.gestion.repositories.DiaSemanaRepository;
import org.utic.webapp.gestion.repositories.PlanCursoHorarioRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class PlanCursoHorarioServiceImpl implements PlanCursoHorarioService{
    @Inject
    PlanCursoHorarioRepository repoPlanCursoHorario;

    @Inject
    AulaRepository repoAula;

    @Inject
    DiaSemanaRepository repoDiaSemana;


    @Override
    public List<DiaSemana> getDiasSemanaAll() {
        return repoDiaSemana.getAll();
    }

    @Override
    public List<Aula> getAulasAll() {
        return repoAula.getAll();
    }

    @Override
    public List<PlanCursoHorario> getPlanesCursosHorariosAllByPlanCurso(PlanCurso planCurso) {
        return repoPlanCursoHorario.getAllByPlanCurso(planCurso);
    }

    @Override
    public List<PlanCursoHorario> getAll() {
        return repoPlanCursoHorario.getAll();
    }

    @Override
    public PlanCursoHorario getById(Long id) {
        return repoPlanCursoHorario.getById(id);
    }

    @Override
    public Mensaje save(PlanCursoHorario planCursoHorario) {
        return repoPlanCursoHorario.save(planCursoHorario);
    }

    @Override
    public Mensaje delete(PlanCursoHorario planCursoHorario) {
        return repoPlanCursoHorario.delete(planCursoHorario);
    }
}
