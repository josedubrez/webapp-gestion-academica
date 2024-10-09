package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;
import java.util.List;

@Local
public interface MallaDetService extends CrudService<MallaDet> {
    List<Materia> getMateriasAll();
    List<MallaDet> getAllByMalla(Malla malla);
}
