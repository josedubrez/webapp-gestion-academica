package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.ContratoDocente;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.repositories.ContratoDocenteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ContratoDocenteServiceImpl implements ContratoDocenteService{
    @Inject
    ContratoDocenteRepository repoContratoDocente;

    @Override
    public List<ContratoDocente> getContratosDocentesAllByDocente(Docente docente) {
        return repoContratoDocente.getAllByDocente(docente);
    }

    @Override
    public List<ContratoDocente> getAll() {
        return repoContratoDocente.getAll();
    }

    @Override
    public ContratoDocente getById(Long id) {
        return repoContratoDocente.getById(id);
    }

    @Override
    public Mensaje save(ContratoDocente contratoDocente) {
        return repoContratoDocente.save(contratoDocente);
    }

    @Override
    public Mensaje delete(ContratoDocente contratoDocente) {
        return repoContratoDocente.delete(contratoDocente);
    }
}
