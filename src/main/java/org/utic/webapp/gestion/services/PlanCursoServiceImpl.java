package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class PlanCursoServiceImpl implements PlanCursoService{
    @Inject
    PlanCursoRepository repoPlanCurso;

    @Inject
    SedeRepository repoSede;

    @Inject
    TurnoRepository repoTurno;

    @Inject
    DocenteRepository repoDocente;

    @Inject
    MallaDetRepository repoMallaDet;

    @Override
    public List<Sede> getSedesAll() {
        return repoSede.getAll();
    }

    @Override
    public List<Turno> getTurnosAll() {
        return repoTurno.getAll();
    }

    @Override
    public List<Docente> getDocentesAll() {
        return repoDocente.getAll();
    }

    @Override
    public List<MallaDet> getMallasDetAll() {
        return repoMallaDet.getAll();
    }

    @Override
    public List<PlanCurso> getAllByDocente(Docente docente) {
        return repoPlanCurso.getAllByDocente(docente);
    }

    @Override
    public List<PlanCurso> getAll() {
        return repoPlanCurso.getAll();
    }

    @Override
    public PlanCurso getById(Long id) {
        return repoPlanCurso.getById(id);
    }

    @Override
    public Mensaje save(PlanCurso planCurso) {
        return repoPlanCurso.save(planCurso);
    }

    @Override
    public Mensaje delete(PlanCurso planCurso) {
        return repoPlanCurso.delete(planCurso);
    }
}
