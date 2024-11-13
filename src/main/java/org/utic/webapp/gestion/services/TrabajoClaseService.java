package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.TrabajoClase;

import java.util.List;

@Local
public interface TrabajoClaseService extends CrudService<TrabajoClase>{
    List<TrabajoClase> getAllByClase(Clase clase);
}
