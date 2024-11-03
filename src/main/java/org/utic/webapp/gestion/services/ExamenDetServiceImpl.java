package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.ExamenDet;
import org.utic.webapp.gestion.repositories.ExamenDetRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ExamenDetServiceImpl implements ExamenDetService {

    @Inject
    private ExamenDetRepository repo;

    @Override
    public List<ExamenDet> getAllByExamen(Examen examen) {
        return repo.getAllByExamen(examen);
    }

    @Override
    public List<ExamenDet> getAll() {
        return repo.getAll();
    }

    @Override
    public ExamenDet getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(ExamenDet examenDet) {
        return repo.save(examenDet);
    }

    @Override
    public Mensaje delete(ExamenDet examenDet) {
        return repo.delete(examenDet);
    }
}
