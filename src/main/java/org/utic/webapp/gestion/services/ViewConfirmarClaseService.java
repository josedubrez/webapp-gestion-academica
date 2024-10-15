package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Local
public interface ViewConfirmarClaseService extends ViewService<ViewConfirmarClase>{
    List<ViewConfirmarClase> getAllByDocente(Docente docente);
    Mensaje insertClase(ViewConfirmarClase vcc);
}
