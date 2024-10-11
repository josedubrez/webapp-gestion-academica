package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Rol;
import org.utic.webapp.gestion.entities.RolUsuario;
import org.utic.webapp.gestion.entities.Usuario;
import org.utic.webapp.gestion.repositories.RolRepository;
import org.utic.webapp.gestion.repositories.RolUsuarioRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class RolUsuarioServiceImpl implements RolUsuarioService{

    @Inject
    RolUsuarioRepository repo;

    @Inject
    RolRepository repoRol;

    @Override
    public List<Rol> getRolesAll() {
        return repoRol.getAll();
    }

    @Override
    public List<RolUsuario> getAllByUsuario(Usuario usuario) {
        return repo.getAllByUsuario(usuario);
    }

    @Override
    public List<RolUsuario> getAll() {
        return repo.getAll();
    }

    @Override
    public RolUsuario getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(RolUsuario rolUsuario) {
        return repo.save(rolUsuario);
    }

    @Override
    public Mensaje delete(RolUsuario rolUsuario) {
        return repo.delete(rolUsuario);
    }
}
