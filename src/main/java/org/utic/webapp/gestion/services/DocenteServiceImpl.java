package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.Titulo;
import org.utic.webapp.gestion.repositories.DocenteRepository;
import org.utic.webapp.gestion.repositories.TituloRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class DocenteServiceImpl implements DocenteService{
    @Inject
    DocenteRepository repoDocente;

    @Inject
    TituloRepository repoTitulo;

    @Override
    public List<Docente> getAll() {
        return repoDocente.getAll();
    }

    @Override
    public Docente getById(Long id) {
        return repoDocente.getById(id);
    }

    @Override
    public Mensaje save(Docente docente) {
        return repoDocente.save(docente);
    }

    @Override
    public Mensaje delete(Docente docente) {
        return repoDocente.delete(docente);
    }

    @Override
    public List<Titulo> getTitulosAll() {
        return repoTitulo.getAll();
    }
}
