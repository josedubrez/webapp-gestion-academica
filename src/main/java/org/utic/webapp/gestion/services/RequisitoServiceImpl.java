package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Requisito;
import org.utic.webapp.gestion.repositories.RequisitoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class RequisitoServiceImpl implements RequisitoService {
    @Inject
    RequisitoRepository repo;

    @Override
    public List<Requisito> getAll() {
        return repo.getAll();
    }

    @Override
    public Requisito getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Requisito requisito) {
        return repo.save(requisito);
    }

    @Override
    public Mensaje delete(Requisito requisito) {
        return repo.delete(requisito);
    }

}
