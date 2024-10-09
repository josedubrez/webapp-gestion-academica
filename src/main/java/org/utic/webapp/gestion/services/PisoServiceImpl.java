package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Piso;
import org.utic.webapp.gestion.repositories.PisoRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class PisoServiceImpl implements PisoService{

    @Inject
    PisoRepository repoPiso;

    @Override
    public List<Piso> getAll() {
        return repoPiso.getAll();
    }

    @Override
    public Piso getById(Long id) {
        return repoPiso.getById(id);
    }

    @Override
    public Mensaje save(Piso piso) {
        return repoPiso.save(piso);
    }

    @Override
    public Mensaje delete(Piso piso) {
        return repoPiso.delete(piso);
    }
}
