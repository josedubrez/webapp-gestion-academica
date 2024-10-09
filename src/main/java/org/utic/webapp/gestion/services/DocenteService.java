package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Titulo;
import org.utic.webapp.gestion.entities.Docente;

import java.util.List;

@Local
public interface DocenteService extends CrudService<Docente> {
    List<Titulo> getTitulosAll();
}
