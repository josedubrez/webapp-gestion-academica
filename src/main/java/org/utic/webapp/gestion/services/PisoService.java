package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Piso;

@Local
public interface PisoService extends  CrudService<Piso> {
}
