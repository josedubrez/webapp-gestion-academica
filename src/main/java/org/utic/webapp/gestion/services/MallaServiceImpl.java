package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;

import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Carrera;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.repositories.CarreraRepository;
import org.utic.webapp.gestion.repositories.CrudRepository;
import org.utic.webapp.gestion.repositories.MallaRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class MallaServiceImpl implements MallaService{

    @Inject
    MallaRepository repoMalla;

    @Inject
    CarreraRepository repoCarrera;

    @Override
    public List<Malla> getAll() {
        return repoMalla.getAll();
    }

    @Override
    public Malla getById(Long id) {
        return repoMalla.getById(id);
    }

    @Override
    public Mensaje save(Malla malla) {
        return repoMalla.save(malla);
    }

    @Override
    public Mensaje delete(Malla malla) {
        return repoMalla.delete(malla);
    }

    @Override
    public List<Carrera> getCarrerasAll() {
        return repoCarrera.getAll();
    }
}
