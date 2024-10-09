package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.entities.TrabajoPractico;
import org.utic.webapp.gestion.repositories.TrabajoPracticoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TrabajoPracticoServiceImpl implements TrabajoPracticoService{
    @Inject
    TrabajoPracticoRepository repo;

    @Override
    public List<TrabajoPractico> getAllByPlanCurso(PlanCurso planCurso) {
        return repo.getAllByPlanCurso(planCurso);
    }

    @Override
    public List<TrabajoPractico> getAll() {
        return repo.getAll();
    }

    @Override
    public TrabajoPractico getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(TrabajoPractico trabajoPractico) {
        return repo.save(trabajoPractico);
    }

    @Override
    public Mensaje delete(TrabajoPractico trabajoPractico) {
        return repo.delete(trabajoPractico);
    }
}
