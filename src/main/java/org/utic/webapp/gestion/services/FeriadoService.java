package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Feriado;
import org.utic.webapp.gestion.entities.Sede;

import java.util.List;

@Local
public interface FeriadoService extends CrudService<Feriado>{
    List<Sede> getSedesAll();
}
