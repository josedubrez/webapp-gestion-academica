package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.MallaDet;
import org.utic.webapp.gestion.entities.Materia;
import org.utic.webapp.gestion.entities.Referencial;
import org.utic.webapp.gestion.entities.Temario;

import java.util.List;

@Local
public interface ReferencialService extends CrudService<Referencial>{
    List<Referencial> getReferencialAllByMallaDet(MallaDet mallaDet);
    List<Materia> getMateriasAll();
}
