package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.DiaSemana;
import org.utic.webapp.gestion.repositories.DiaSemanaRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class DiaSemanaServiceImpl implements DiaSemanaService{
    @Inject
    DiaSemanaRepository repoDiaSemana;


    @Override
    public List<DiaSemana> getAll() {
        return repoDiaSemana.getAll();
    }

    @Override
    public DiaSemana getById(Long id) {
        return repoDiaSemana.getById(id);
    }

    @Override
    public Mensaje save(DiaSemana diaSemana) {
        return repoDiaSemana.save(diaSemana);
    }

    @Override
    public Mensaje delete(DiaSemana diaSemana) {
        return repoDiaSemana.delete(diaSemana);
    }
}
