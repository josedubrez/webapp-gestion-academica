package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Usuario;

@Local
public interface UsuarioService extends CrudService<Usuario>{
}
