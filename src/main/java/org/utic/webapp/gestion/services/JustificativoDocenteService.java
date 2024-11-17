package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.JustificativoDocente;
import org.utic.webapp.gestion.entities.PermisoDocente;

import java.util.List;

@Local
public interface JustificativoDocenteService extends CrudService<JustificativoDocente>{
    List<Docente> getDocentesAll();
}
