package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Usuario;
import org.utic.webapp.gestion.repositories.UsuarioRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    UsuarioRepository repo;

    @Override
    public List<Usuario> getAll() {
        return repo.getAll();
    }

    @Override
    public Usuario getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Mensaje delete(Usuario usuario) {
        return repo.delete(usuario);
    }
}
