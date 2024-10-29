package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.DistribucionEscala;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.repositories.DistribucionEscalaRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class DistribucionEscalaServiceImpl implements DistribucionEscalaService{

    @Inject
    private DistribucionEscalaRepository repo;

    @Override
    public List<DistribucionEscala> getAllByPlanCurso(PlanCurso planCurso) {
        return repo.getAllByPlanCurso(planCurso);
    }

    @Override
    public List<DistribucionEscala> getAll() {
        return repo.getAll();
    }

    @Override
    public DistribucionEscala getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(DistribucionEscala distribucionEscala) {
        return repo.save(distribucionEscala);
    }

    @Override
    public Mensaje delete(DistribucionEscala distribucionEscala) {
        return repo.delete(distribucionEscala);
    }
}
