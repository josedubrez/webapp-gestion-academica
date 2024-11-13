package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Calificacion;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.repositories.CalificacionRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class CalificacionServiceImpl implements CalificacionService{

    @Inject
    private CalificacionRepository repo;

    @Override
    public List<Calificacion> getAllByPlanCurso(PlanCurso planCurso) {
        return repo.getAllByPlanCurso(planCurso);
    }

    @Override
    public List<Calificacion> getAll() {
        return repo.getAll();
    }

    @Override
    public Calificacion getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Calificacion calificacion) {
        return repo.save(calificacion);
    }

    @Override
    public Mensaje delete(Calificacion calificacion) {
        return repo.delete(calificacion);
    }
}
