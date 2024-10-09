package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Postulante;
import org.utic.webapp.gestion.repositories.PostulanteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class PostulanteServiceImpl implements PostulanteService{
    @Inject
    PostulanteRepository repo;

    @Override
    public List<Postulante> getAll() {
        return repo.getAll();
    }

    @Override
    public Postulante getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Postulante postulante) {
        return repo.save(postulante);
    }

    @Override
    public Mensaje delete(Postulante postulante) {
        return repo.delete(postulante);
    }
}
