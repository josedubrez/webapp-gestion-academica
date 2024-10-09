package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Aula;
import org.utic.webapp.gestion.entities.Piso;
import org.utic.webapp.gestion.entities.Seccion;
import org.utic.webapp.gestion.repositories.AulaRepository;
import org.utic.webapp.gestion.repositories.PisoRepository;
import org.utic.webapp.gestion.repositories.SeccionRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class AulaServiceImpl implements AulaService{
    @Inject
    AulaRepository repoAula;

    @Inject
    PisoRepository repoPiso;

    @Inject
    SeccionRepository repoSeccion;

    @Override
    public List<Aula> getAll() {
        return repoAula.getAll();
    }

    @Override
    public Aula getById(Long id) {
        return repoAula.getById(id);
    }

    @Override
    public Mensaje save(Aula aula) {
        return repoAula.save(aula);
    }

    @Override
    public Mensaje delete(Aula aula) {
        return repoAula.delete(aula);
    }

    @Override
    public List<Piso> getPisosAll() {
        return repoPiso.getAll();
    }

    @Override
    public List<Seccion> getSeccionesAll() {
        return repoSeccion.getAll();
    }
}
