package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.SancionAlumno;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.SancionAlumno;
import org.utic.webapp.gestion.repositories.AlumnoRepository;
import org.utic.webapp.gestion.repositories.SancionAlumnoRepository;
import org.utic.webapp.gestion.repositories.MallaRepository;
import org.utic.webapp.gestion.repositories.SancionAlumnoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class SancionAlumnoServiceImpl implements SancionAlumnoService{

    @Inject
    private AlumnoRepository repoAlumno;

    @Inject
    MallaRepository repoMalla;

    @Inject
    private SancionAlumnoRepository repoSancionAlumno;

    @Override
    public List<Alumno> getAlumnoAll() {
        return repoAlumno.getAll();
    }

    @Override
    public List<SancionAlumno> getAll() {
        return repoSancionAlumno.getAll();
    }

    @Override
    public SancionAlumno getById(Long id) {
        return repoSancionAlumno.getById(id);
    }

    @Override
    public Mensaje save(SancionAlumno sancionAlumno) {
        return repoSancionAlumno.save(sancionAlumno);
    }

    @Override
    public Mensaje delete(SancionAlumno sancionAlumno) {
        return repoSancionAlumno.delete(sancionAlumno);
    }
    @Override
    public List<Malla> getMallaAll() {
        return repoMalla.getAll();
    }
}
