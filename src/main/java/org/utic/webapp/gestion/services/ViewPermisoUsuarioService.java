package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.ViewPermisoUsuario;

@Local
public interface ViewPermisoUsuarioService extends ViewService<ViewPermisoUsuario>{
    ViewPermisoUsuario getByUsernameAndPassword(String username, String password);
}
