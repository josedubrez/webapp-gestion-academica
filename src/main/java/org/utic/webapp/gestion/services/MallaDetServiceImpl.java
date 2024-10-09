package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.CrudRepository;
import org.utic.webapp.gestion.repositories.MallaDetRepository;
import org.utic.webapp.gestion.repositories.MateriaRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class MallaDetServiceImpl implements MallaDetService{

    @Inject
    MallaDetRepository repoMallaDet;

    @Inject
    MateriaRepository repoMaterias;

    @Override
    public List<Materia> getMateriasAll() {
        return repoMaterias.getAll();
    }

    @Override
    public List<MallaDet> getAllByMalla(Malla malla) {
        return repoMallaDet.getAllByMalla(malla);
    }

    @Override
    public List<MallaDet> getAll() {
        return repoMallaDet.getAll();
    }

    @Override
    public MallaDet getById(Long id) {
        return repoMallaDet.getById(id);
    }

    @Override
    public Mensaje save(MallaDet mallaDet) {
        return repoMallaDet.save(mallaDet);
    }

    @Override
    public Mensaje delete(MallaDet mallaDet) {
        return repoMallaDet.delete(mallaDet);
    }
}
