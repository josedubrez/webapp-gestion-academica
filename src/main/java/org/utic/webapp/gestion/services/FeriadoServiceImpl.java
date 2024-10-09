package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Feriado;
import org.utic.webapp.gestion.entities.Sede;
import org.utic.webapp.gestion.repositories.FeriadoRepository;
import org.utic.webapp.gestion.repositories.SedeRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class FeriadoServiceImpl implements FeriadoService{

    @Inject
    FeriadoRepository repo;

    @Inject
    SedeRepository repoSede;

    @Override
    public List<Feriado> getAll() {
        return repo.getAll();
    }

    @Override
    public Feriado getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(Feriado feriado) {
        return repo.save(feriado);
    }

    @Override
    public Mensaje delete(Feriado feriado) {
        return repo.delete(feriado);
    }

    @Override
    public List<Sede> getSedesAll() {
        return repoSede.getAll();
    }
}
