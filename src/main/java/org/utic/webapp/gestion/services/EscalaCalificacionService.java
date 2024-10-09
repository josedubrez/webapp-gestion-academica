package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.EscalaCalificacion;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.MallaDet;

import java.util.List;

@Local
public interface EscalaCalificacionService extends CrudService<EscalaCalificacion>{
    List<EscalaCalificacion> getAllByMalla(Malla malla);
}
