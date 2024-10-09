package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Carrera;
import org.utic.webapp.gestion.repositories.CarreraRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class CarreraServiceImpl implements CarreraService{

    @Inject
    CarreraRepository repoCarrera;

    @Override
    public List<Carrera> getAll() {
        return repoCarrera.getAll();
    }

    @Override
    public Carrera getById(Long id) {
        return repoCarrera.getById(id);
    }

    @Override
    public Mensaje save(Carrera carrera) {
        return repoCarrera.save(carrera);
    }

    @Override
    public Mensaje delete(Carrera carrera) {
        return repoCarrera.delete(carrera);
    }
}
