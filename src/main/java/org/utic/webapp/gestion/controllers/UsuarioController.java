package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Usuario;

@Named
@ViewScoped
public class UsuarioController extends AbstractCrudController<Usuario>{
    @Override
    protected Usuario createNewInstance() {
        return new Usuario();
    }

    public String irARolesUsuarios() {
        return "roles_usuarios?faces-redirect=true";
    }
}
