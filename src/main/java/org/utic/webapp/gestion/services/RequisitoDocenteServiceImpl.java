package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.RequisitoDocente;
import org.utic.webapp.gestion.repositories.RequisitoDocenteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class RequisitoDocenteServiceImpl implements RequisitoDocenteService{
    @Inject
    RequisitoDocenteRepository repoRequisitoDocente;

    @Override
    public List<RequisitoDocente> getAll() {
        return repoRequisitoDocente.getAll();
    }

    @Override
    public RequisitoDocente getById(Long id) {
        return repoRequisitoDocente.getById(id);
    }

    @Override
    public Mensaje save(RequisitoDocente requisitoDocente) {
        return repoRequisitoDocente.save(requisitoDocente);
    }

    @Override
    public Mensaje delete(RequisitoDocente requisitoDocente) {
        return repoRequisitoDocente.delete(requisitoDocente);
    }
}
