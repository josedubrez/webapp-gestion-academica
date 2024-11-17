package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.JustificativoDocente;
import org.utic.webapp.gestion.entities.PermisoDocente;
import org.utic.webapp.gestion.repositories.DocenteRepository;
import org.utic.webapp.gestion.repositories.JustificativoDocenteRepository;
import org.utic.webapp.gestion.repositories.PermisoDocenteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class JustificativoDocenteServiceImpl implements JustificativoDocenteService{

    @Inject
    private DocenteRepository repoDocente;

    @Inject
    private JustificativoDocenteRepository repoJustificativoDocente;

    @Override
    public List<Docente> getDocentesAll() {
        return repoDocente.getAll();
    }

    @Override
    public List<JustificativoDocente> getAll() {
        return repoJustificativoDocente.getAll();
    }

    @Override
    public JustificativoDocente getById(Long id) {
        return repoJustificativoDocente.getById(id);
    }

    @Override
    public Mensaje save(JustificativoDocente justificativoDocente) {
        return repoJustificativoDocente.save(justificativoDocente);
    }

    @Override
    public Mensaje delete(JustificativoDocente justificativoDocente) {
        return repoJustificativoDocente.delete(justificativoDocente);
    }
}
