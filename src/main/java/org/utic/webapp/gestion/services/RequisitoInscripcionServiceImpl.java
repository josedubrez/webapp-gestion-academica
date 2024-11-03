package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.Requisito;
import org.utic.webapp.gestion.entities.RequisitoInscripcion;
import org.utic.webapp.gestion.repositories.MallaRepository;
import org.utic.webapp.gestion.repositories.RequisitoInscripcionRepository;
import org.utic.webapp.gestion.repositories.RequisitoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class RequisitoInscripcionServiceImpl implements RequisitoInscripcionService{
    @Inject
    RequisitoInscripcionRepository repo;

    @Inject
    RequisitoRepository repoRequisito;

    @Override
    public List<Requisito> getRequisitoAll() {
        return repoRequisito.getAll();
    }

    @Override
    public List<RequisitoInscripcion> getAllByMalla(Malla malla) {
        return repo.getAllByMalla(malla);
    }

    @Override
    public List<RequisitoInscripcion> getAll() {
        return repo.getAll();
    }

    @Override
    public RequisitoInscripcion getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(RequisitoInscripcion requisitoInscripcion) {
        return repo.save(requisitoInscripcion);
    }

    @Override
    public Mensaje delete(RequisitoInscripcion requisitoInscripcion) {
        return repo.delete(requisitoInscripcion);
    }
}
