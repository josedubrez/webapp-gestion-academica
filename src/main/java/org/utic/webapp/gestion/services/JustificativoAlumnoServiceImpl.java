package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.JustificativoAlumno;
import org.utic.webapp.gestion.entities.PermisoDocente;
import org.utic.webapp.gestion.repositories.AlumnoRepository;
import org.utic.webapp.gestion.repositories.DocenteRepository;
import org.utic.webapp.gestion.repositories.JustificativoAlumnoRepository;
import org.utic.webapp.gestion.repositories.PermisoDocenteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class JustificativoAlumnoServiceImpl implements JustificativoAlumnoService{

    @Inject
    private AlumnoRepository repoAlumno;

    @Inject
    private JustificativoAlumnoRepository repoJustificativoAlumno;

    @Override
    public List<Alumno> getAlumnoAll() {
        return repoAlumno.getAll();
    }

    @Override
    public List<JustificativoAlumno> getAll() {
        return repoJustificativoAlumno.getAll();
    }

    @Override
    public JustificativoAlumno getById(Long id) {
        return repoJustificativoAlumno.getById(id);
    }

    @Override
    public Mensaje save(JustificativoAlumno justificativoAlumno) {
        return repoJustificativoAlumno.save(justificativoAlumno);
    }

    @Override
    public Mensaje delete(JustificativoAlumno justificativoAlumno) {
        return repoJustificativoAlumno.delete(justificativoAlumno);
    }
}
