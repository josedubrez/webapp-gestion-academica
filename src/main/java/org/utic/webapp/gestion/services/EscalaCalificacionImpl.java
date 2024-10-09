package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.EscalaCalificacion;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.repositories.EscalaCalificacionRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class EscalaCalificacionImpl implements EscalaCalificacionService{
    @Inject
    EscalaCalificacionRepository repoEscalaCalificacion;

    @Override
    public List<EscalaCalificacion> getAllByMalla(Malla malla) {
        return repoEscalaCalificacion.getAllByMalla(malla);
    }

    @Override
    public List<EscalaCalificacion> getAll() {
        return repoEscalaCalificacion.getAll();
    }

    @Override
    public EscalaCalificacion getById(Long id) {
        return repoEscalaCalificacion.getById(id);
    }

    @Override
    public Mensaje save(EscalaCalificacion escalaCalificacion) {
        return repoEscalaCalificacion.save(escalaCalificacion);
    }

    @Override
    public Mensaje delete(EscalaCalificacion escalaCalificacion) {
        return repoEscalaCalificacion.delete(escalaCalificacion);
    }
}
