package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.PermisoDocente;
import org.utic.webapp.gestion.repositories.DocenteRepository;
import org.utic.webapp.gestion.repositories.PermisoDocenteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class PermisoDocenteServiceImpl implements PermisoDocenteService{

    @Inject
    private DocenteRepository repoDocente;

    @Inject
    private PermisoDocenteRepository repoPermisoDocente;

    @Override
    public List<Docente> getDocentesAll() {
        return repoDocente.getAll();
    }

    @Override
    public List<PermisoDocente> getAll() {
        return repoPermisoDocente.getAll();
    }

    @Override
    public PermisoDocente getById(Long id) {
        return repoPermisoDocente.getById(id);
    }

    @Override
    public Mensaje save(PermisoDocente permisoDocente) {
        return repoPermisoDocente.save(permisoDocente);
    }

    @Override
    public Mensaje delete(PermisoDocente permisoDocente) {
        return repoPermisoDocente.delete(permisoDocente);
    }
}
