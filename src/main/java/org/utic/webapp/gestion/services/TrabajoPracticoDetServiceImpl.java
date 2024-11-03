package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.TrabajoPractico;
import org.utic.webapp.gestion.entities.TrabajoPracticoDet;
import org.utic.webapp.gestion.repositories.TrabajoPracticoDetRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class TrabajoPracticoDetServiceImpl implements TrabajoPracticoDetService{

    @Inject
    private TrabajoPracticoDetRepository repo;

    @Override
    public List<TrabajoPracticoDet> getAllByTrabajoPractico(TrabajoPractico trabajoPractico) {
        return repo.getAllByTrabajoPractico(trabajoPractico);
    }

    @Override
    public List<TrabajoPracticoDet> getAll() {
        return repo.getAll();
    }

    @Override
    public TrabajoPracticoDet getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(TrabajoPracticoDet trabajoPracticoDet) {
        return repo.save(trabajoPracticoDet);
    }

    @Override
    public Mensaje delete(TrabajoPracticoDet trabajoPracticoDet) {
        return repo.delete(trabajoPracticoDet);
    }
}
