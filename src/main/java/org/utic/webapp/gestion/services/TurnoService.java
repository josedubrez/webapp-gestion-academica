package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Turno;
import org.utic.webapp.gestion.repositories.TurnoRepository;

@Local
public interface TurnoService extends CrudService<Turno>{
}
