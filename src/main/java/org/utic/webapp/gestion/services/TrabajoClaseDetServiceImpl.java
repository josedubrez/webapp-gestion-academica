package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.TrabajoClase;
import org.utic.webapp.gestion.entities.TrabajoClaseDet;
import org.utic.webapp.gestion.repositories.TrabajoClaseDetRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TrabajoClaseDetServiceImpl implements TrabajoClaseDetService{

    @Inject
    private TrabajoClaseDetRepository repo;

    @Override
    public List<TrabajoClaseDet> getAllByTrabajoClase(TrabajoClase trabajoClase) {
        return repo.getAllByTrabajoClase(trabajoClase);
    }

    @Override
    public List<TrabajoClaseDet> getAll() {
        return repo.getAll();
    }

    @Override
    public TrabajoClaseDet getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(TrabajoClaseDet trabajoClaseDet) {
        return repo.save(trabajoClaseDet);
    }

    @Override
    public Mensaje delete(TrabajoClaseDet trabajoClaseDet) {
        return repo.delete(trabajoClaseDet);
    }
}
