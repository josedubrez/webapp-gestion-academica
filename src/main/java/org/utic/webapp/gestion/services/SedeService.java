package org.utic.webapp.gestion.services;

import org.utic.webapp.gestion.entities.*;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface SedeService extends CrudService<Sede>{
    List<Ciudad> getCiudadesAll();
}
