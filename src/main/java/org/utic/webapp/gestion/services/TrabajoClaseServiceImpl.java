package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.TrabajoClase;
import org.utic.webapp.gestion.repositories.TrabajoClaseRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TrabajoClaseServiceImpl implements TrabajoClaseService{
    @Inject
    private TrabajoClaseRepository repo;

    @Override
    public List<TrabajoClase> getAllByClase(Clase clase) {
        return repo.getAllByClase(clase);
    }

    @Override
    public List<TrabajoClase> getAll() {
        return repo.getAll();
    }

    @Override
    public TrabajoClase getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(TrabajoClase trabajoClase) {
        return repo.save(trabajoClase);
    }

    @Override
    public Mensaje delete(TrabajoClase trabajoClase) {
        return repo.delete(trabajoClase);
    }
}
