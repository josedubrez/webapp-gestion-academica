package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.ViewCalificacionPendiente;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Local
public interface ViewCalificacionPendienteService extends ViewService<ViewCalificacionPendiente>{
    List<ViewCalificacionPendiente> getAllByDocente(Docente docente);
    Mensaje insertCalificacion(ViewCalificacionPendiente vcp);
}
