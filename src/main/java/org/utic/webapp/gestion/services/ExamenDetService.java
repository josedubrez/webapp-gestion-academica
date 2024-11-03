package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.ExamenDet;

import java.util.List;

@Local
public interface ExamenDetService extends CrudService<ExamenDet>{
    List<ExamenDet> getAllByExamen(Examen examen);
}
