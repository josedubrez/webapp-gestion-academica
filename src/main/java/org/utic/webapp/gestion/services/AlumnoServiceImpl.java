package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.repositories.AlumnoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class AlumnoServiceImpl implements AlumnoService{
    @Inject
    AlumnoRepository repo;

    @Override
    public List<Alumno> getAll() {
        return repo.getAll();
    }

    @Override
    public Alumno getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Alumno alumno) {
        return repo.save(alumno);
    }

    @Override
    public Mensaje delete(Alumno alumno) {
        return repo.delete(alumno);
    }
}
