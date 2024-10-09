package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Materia;
import org.utic.webapp.gestion.repositories.CrudRepository;
import org.utic.webapp.gestion.repositories.MateriaRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class MateriaServiceImpl implements MateriaService{

    @Inject
    MateriaRepository repoMateria;

    @Override
    public List<Materia> getAll() {
        return repoMateria.getAll();
    }

    @Override
    public Materia getById(Long id) {
        return repoMateria.getById(id);
    }

    @Override
    public Mensaje save(Materia materia) {
        return repoMateria.save(materia);
    }

    @Override
    public Mensaje delete(Materia materia) {
        return repoMateria.delete(materia);
    }
}
