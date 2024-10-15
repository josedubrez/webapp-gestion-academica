package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.repositories.ClaseRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ClaseServiceImpl implements ClaseService{

    @Inject
    ClaseRepository repo;

    @Override
    public List<Clase> getAllByPlanCurso(PlanCurso planCurso) {
        return repo.getAllByPlanCurso(planCurso);
    }

    @Override
    public List<Clase> getAll() {
        return repo.getAll();
    }

    @Override
    public Clase getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Clase clase) {
        return repo.save(clase);
    }

    @Override
    public Mensaje delete(Clase clase) {
        return repo.delete(clase);
    }
}
