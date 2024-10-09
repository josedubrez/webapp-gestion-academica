package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface AulaService extends CrudService<Aula>{
    List<Piso> getPisosAll();
    List<Seccion> getSeccionesAll();
}
