package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.DesercionAlumno;
import org.utic.webapp.gestion.repositories.AlumnoRepository;
import org.utic.webapp.gestion.repositories.MallaRepository;
import org.utic.webapp.gestion.repositories.DesercionAlumnoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class DesercionAlumnoServiceImpl implements DesercionAlumnoService{

    @Inject
    private AlumnoRepository repoAlumno;

    @Inject
    MallaRepository repoMalla;

    @Inject
    private DesercionAlumnoRepository repoDesercionAlumno;

    @Override
    public List<Alumno> getAlumnoAll() {
        return repoAlumno.getAll();
    }

    @Override
    public List<DesercionAlumno> getAll() {
        return repoDesercionAlumno.getAll();
    }

    @Override
    public DesercionAlumno getById(Long id) {
        return repoDesercionAlumno.getById(id);
    }

    @Override
    public Mensaje save(DesercionAlumno desercionAlumno) {
        return repoDesercionAlumno.save(desercionAlumno);
    }

    @Override
    public Mensaje delete(DesercionAlumno desercionAlumno) {
        return repoDesercionAlumno.delete(desercionAlumno);
    }
    @Override
    public List<Malla> getMallaAll() {
        return repoMalla.getAll();
    }
}
