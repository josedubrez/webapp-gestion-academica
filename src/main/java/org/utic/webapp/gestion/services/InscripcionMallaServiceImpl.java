package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class InscripcionMallaServiceImpl implements InscripcionMallaService{

    @Inject
    InscripcionMallaRepository repo;

    @Inject
    MallaRepository repoMalla;

    @Inject
    SedeRepository repoSede;

    @Inject
    TurnoRepository repoTurno;

    @Inject
    AlumnoRepository repoAlumno;

    @Override
    public List<Malla> getMallasAll() {
        return repoMalla.getAll();
    }

    @Override
    public List<Sede> getSedesAll() {
        return repoSede.getAll();
    }

    @Override
    public List<Turno> getTurnosAll() {
        return repoTurno.getAll();
    }

    @Override
    public List<Alumno> getAlumnoAll() { return repoAlumno.getAll();
    }

    @Override
    public List<InscripcionMalla> getAllByAlumno(Alumno alumno) {
        return repo.getAllByAlumno(alumno);
    }

    @Override
    public List<InscripcionMalla> getAll() {
        return repo.getAll();
    }

    @Override
    public InscripcionMalla getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(InscripcionMalla inscripcionMalla) {
        return repo.save(inscripcionMalla);
    }

    @Override
    public Mensaje delete(InscripcionMalla inscripcionMalla) {
        return repo.delete(inscripcionMalla);
    }
}
