package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;

import org.utic.webapp.gestion.entities.Carrera;
import org.utic.webapp.gestion.entities.Malla;

import java.util.List;

@Local
public interface MallaService extends CrudService<Malla>{
    List<Carrera> getCarrerasAll();
}