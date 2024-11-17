package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Mensaje;

import java.sql.Ref;
import java.util.List;

@Stateless
public class ReferencialServiceImpl implements ReferencialService{

    @Inject
    ReferencialRepository repoReferencial;

    @Inject
    MateriaRepository repoMaterias;

    @Override
    public List<Materia> getMateriasAll() {
        return repoMaterias.getAll();
    }

    @Override
    public List<Referencial> getReferencialAllByMallaDet(MallaDet mallaDet) {
        return repoReferencial.getAllByMallaDet(mallaDet);
    }
    @Override
    public List<Referencial> getAll() {
        return repoReferencial.getAll();
    }

    @Override
    public Referencial getById(Long id) {
        return repoReferencial.getById(id);
    }

    @Override
    public Mensaje save(Referencial referencial) {
        return repoReferencial.save(referencial);
    }

    @Override
    public Mensaje delete(Referencial referencial) {
        return repoReferencial.delete(referencial);
    }

}
