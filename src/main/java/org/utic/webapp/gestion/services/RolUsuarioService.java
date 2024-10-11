package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface RolUsuarioService extends CrudService<RolUsuario>{
    List<Rol> getRolesAll();
    List<RolUsuario> getAllByUsuario(Usuario usuario);
}
