package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Usuario;

@RequestScoped
public class UsuarioRepository extends AbstractCrudRepository<Usuario>{
    @Override
    protected String select() {
        return "SELECT r FROM Usuario r";
    }
}
