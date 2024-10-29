package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.repositories.ExamenRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ExamenServiceImpl implements ExamenService{
    @Inject
    private ExamenRepository repo;

    @Override
    public List<Examen> getAllByPlanCurso(PlanCurso planCurso) {
        return repo.getAllByPlanCurso(planCurso);
    }

    @Override
    public List<Examen> getAll() {
        return repo.getAll();
    }

    @Override
    public Examen getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Examen examen) {
        return repo.save(examen);
    }

    @Override
    public Mensaje delete(Examen examen) {
        return repo.delete(examen);
    }
}
