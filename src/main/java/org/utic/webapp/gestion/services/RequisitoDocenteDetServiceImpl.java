package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Postulante;
import org.utic.webapp.gestion.entities.RequisitoDocente;
import org.utic.webapp.gestion.entities.RequisitoDocenteDet;
import org.utic.webapp.gestion.repositories.RequisitoDocenteDetRepository;
import org.utic.webapp.gestion.repositories.RequisitoDocenteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class RequisitoDocenteDetServiceImpl implements RequisitoDocenteDetService{
    @Inject
    RequisitoDocenteDetRepository repo;

    @Inject
    RequisitoDocenteRepository repoRequisitoDocente;

    @Override
    public List<RequisitoDocente> getRequisitosDocentesAll() {
        return repoRequisitoDocente.getAll();
    }

    @Override
    public List<RequisitoDocenteDet> getAllByPostulante(Postulante postulante) {
        return repo.getAllByPostulante(postulante);
    }

    @Override
    public List<RequisitoDocenteDet> getAll() {
        return repo.getAll();
    }

    @Override
    public RequisitoDocenteDet getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public Mensaje save(RequisitoDocenteDet requisitoDocenteDet) {
        return repo.save(requisitoDocenteDet);
    }

    @Override
    public Mensaje delete(RequisitoDocenteDet requisitoDocenteDet) {
        return repo.delete(requisitoDocenteDet);
    }
}
