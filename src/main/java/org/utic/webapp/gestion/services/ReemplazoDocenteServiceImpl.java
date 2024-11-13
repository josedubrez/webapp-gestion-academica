package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ReemplazoDocenteServiceImpl implements ReemplazoDocenteService{

    @Inject
    ReemplazoDocenteRepository repo;

    @Inject
    DocenteRepository repoDocente;

    @Inject
    PlanCursoRepository repoPlanCurso;

    @Override
    public List<PlanCurso> getPlanCursoAll() { return repoPlanCurso.getAll();
    }

    @Override
    public List<Docente> getDocentesAll() { return repoDocente.getAll();
    }

    @Override
    public List<ReemplazoDocente> getAll() {
        return repo.getAll();
    }

    @Override
    public ReemplazoDocente getById(Long id) {
        return repo.getById(id);
    }


    @Override
    public Mensaje save(ReemplazoDocente reemplazoDocente) {
        return repo.save(reemplazoDocente);
    }

    @Override
    public Mensaje delete(ReemplazoDocente reemplazoDocente) {
        return repo.delete(reemplazoDocente);
    }


}
