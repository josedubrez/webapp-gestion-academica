package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.RequisitoInscripcion;

import java.util.List;

@Local
public interface RequisitoInscripcionService extends CrudService<RequisitoInscripcion>{
    List<RequisitoInscripcion> getAllByMalla(Malla malla);
}
