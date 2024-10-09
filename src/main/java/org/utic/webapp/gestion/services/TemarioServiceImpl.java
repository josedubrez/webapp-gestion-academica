package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.MallaDet;
import org.utic.webapp.gestion.entities.Temario;
import org.utic.webapp.gestion.repositories.TemarioRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TemarioServiceImpl implements TemarioService{

    @Inject
    TemarioRepository repoTemario;

    @Override
    public List<Temario> getTemariosAllByMallaDet(MallaDet mallaDet) {
        return repoTemario.getAllByMallaDet(mallaDet);
    }

    @Override
    public List<Temario> getAll() {
        return repoTemario.getAll();
    }

    @Override
    public Temario getById(Long id) {
        return repoTemario.getById(id);
    }

    @Override
    public Mensaje save(Temario temario) {
        return repoTemario.save(temario);
    }

    @Override
    public Mensaje delete(Temario temario) {
        return repoTemario.delete(temario);
    }
}
