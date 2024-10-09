package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.ContratoDocente;
import org.utic.webapp.gestion.entities.Docente;

import java.util.List;

@Local
public interface ContratoDocenteService extends CrudService<ContratoDocente>{
    List<ContratoDocente> getContratosDocentesAllByDocente(Docente docente);
}
