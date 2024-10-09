package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Titulo;
import org.utic.webapp.gestion.repositories.TituloRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TituloServiceImpl implements TituloService{

    @Inject
    TituloRepository repoTitulo;

    @Override
    public List<Titulo> getAll() {
        return repoTitulo.getAll();
    }

    @Override
    public Titulo getById(Long id) {
        return repoTitulo.getById(id);
    }

    @Override
    public Mensaje save(Titulo titulo) {
        return repoTitulo.save(titulo);
    }

    @Override
    public Mensaje delete(Titulo titulo) {
        return repoTitulo.delete(titulo);
    }
}
