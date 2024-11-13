package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class InscripcionPlanCursoServiceImpl implements InscripcionPlanCursoService{

    @Inject
    InscripcionPlanCursoRepository repo;

    @Inject
    AlumnoRepository repoAlumno;

    @Inject
    DocenteRepository repoDocente;

    @Inject
    PlanCursoRepository repoPlanCurso;

    @Override
    public List<PlanCurso> getPlanCursoAll() { return repoPlanCurso.getAll();
    }

    @Override
    public List<Docente> getDocenteAll() { return repoDocente.getAll();
    }

    @Override
    public List<Alumno> getAlumnoAll() { return repoAlumno.getAll();
    }

    @Override
    public List<InscripcionPlanCurso> getAllByAlumno(Alumno alumno) {
        return repo.getAllByAlumno(alumno);
    }

    @Override
    public List<InscripcionPlanCurso> getAll() {
        return repo.getAll();
    }

    @Override
    public InscripcionPlanCurso getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(InscripcionPlanCurso inscripcionPlanCurso) {
        return repo.save(inscripcionPlanCurso);
    }

    @Override
    public Mensaje delete(InscripcionPlanCurso inscripcionPlanCurso) {
        return repo.delete(inscripcionPlanCurso);
    }
}
