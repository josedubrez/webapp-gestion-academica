package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.TrabajoClase;
import org.utic.webapp.gestion.entities.TrabajoClaseDet;

import java.util.List;

@Local
public interface TrabajoClaseDetService extends CrudService<TrabajoClaseDet>{
    List<TrabajoClaseDet> getAllByTrabajoClase(TrabajoClase trabajoClase);
}
