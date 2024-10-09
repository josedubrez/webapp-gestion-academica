package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Turno;
import org.utic.webapp.gestion.repositories.TurnoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TurnoServiceImpl implements TurnoService{
    @Inject
    TurnoRepository repoTurno;

    @Override
    public List<Turno> getAll() {
        return repoTurno.getAll();
    }

    @Override
    public Turno getById(Long id) {
        return repoTurno.getById(id);
    }

    @Override
    public Mensaje save(Turno turno) {
        return repoTurno.save(turno);
    }

    @Override
    public Mensaje delete(Turno turno) {
        return repoTurno.delete(turno);
    }
}
