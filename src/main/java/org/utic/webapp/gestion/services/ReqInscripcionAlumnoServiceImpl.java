package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ReqInscripcionAlumnoServiceImpl implements ReqInscripcionAlumnoService{

    @Inject
    ReqInscripcionAlumnoRepository repo;

    @Inject
    AlumnoRepository repoAlumno;

    @Inject
    RequisitoRepository repoRequisito;

    @Override
    public List<Requisito> getRequisitoAll() { return repoRequisito.getAll();
    }

    @Override
    public List<Alumno> getAlumnoAll() { return repoAlumno.getAll();
    }

    @Override
    public List<ReqInscripcionAlumno> getAllByAlumno(Alumno alumno) {
        return repo.getAllByAlumno(alumno);
    }

    @Override
    public List<ReqInscripcionAlumno> getAll() {
        return repo.getAll();
    }

    @Override
    public ReqInscripcionAlumno getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(ReqInscripcionAlumno reqInscripcionAlumno) {
        return repo.save(reqInscripcionAlumno);
    }

    @Override
    public Mensaje delete(ReqInscripcionAlumno reqInscripcionAlumno) {
        return repo.delete(reqInscripcionAlumno);
    }
}
