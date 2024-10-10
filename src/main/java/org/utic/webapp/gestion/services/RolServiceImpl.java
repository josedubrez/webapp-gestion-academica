package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Rol;
import org.utic.webapp.gestion.repositories.RolRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class RolServiceImpl implements RolService{

    @Inject
    RolRepository repo;

    @Override
    public List<Rol> getAll() {
        return repo.getAll();
    }

    @Override
    public Rol getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Rol rol) {
        return repo.save(rol);
    }

    @Override
    public Mensaje delete(Rol rol) {
        return repo.delete(rol);
    }
}
