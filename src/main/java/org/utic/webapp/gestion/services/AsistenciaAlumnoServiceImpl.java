package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.AsistenciaAlumno;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.repositories.AsistenciaAlumnoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class AsistenciaAlumnoServiceImpl implements AsistenciaAlumnoService{

    @Inject
    private AsistenciaAlumnoRepository repo;

    @Override
    public List<AsistenciaAlumno> getAllByClase(Clase clase) {
        return repo.getAllByClase(clase);
    }

    @Override
    public List<AsistenciaAlumno> getAllByDocente(Docente docente) {
        return repo.getAllByDocente(docente);
    }

    @Override
    public List<AsistenciaAlumno> getAll() {
        return repo.getAll();
    }

    @Override
    public AsistenciaAlumno getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(AsistenciaAlumno asistenciaAlumno) {
        return repo.save(asistenciaAlumno);
    }

    @Override
    public Mensaje delete(AsistenciaAlumno asistenciaAlumno) {
        return repo.delete(asistenciaAlumno);
    }
}
