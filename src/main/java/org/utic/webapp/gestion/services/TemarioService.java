package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;
import java.util.List;

@Local
public interface TemarioService extends CrudService<Temario>{
    List<Temario> getTemariosAllByMallaDet(MallaDet mallaDet);
}
