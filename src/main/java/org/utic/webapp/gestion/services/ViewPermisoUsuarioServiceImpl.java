package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.ViewPermisoUsuario;
import org.utic.webapp.gestion.repositories.ViewPermisoUsuarioRepository;

import java.util.List;

@Stateless
public class ViewPermisoUsuarioServiceImpl implements ViewPermisoUsuarioService{
    @Inject
    ViewPermisoUsuarioRepository repo;

    @Override
    public List<ViewPermisoUsuario> getAll() {
        return repo.getAll();
    }

    @Override
    public ViewPermisoUsuario getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public ViewPermisoUsuario getByUsernameAndPassword(String username, String password) {
        return repo.getByUsernameAndPassword(username, password);
    }
}
