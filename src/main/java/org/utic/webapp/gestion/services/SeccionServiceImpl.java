package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Seccion;
import org.utic.webapp.gestion.repositories.SeccionRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class SeccionServiceImpl implements SeccionService{

    @Inject
    SeccionRepository repoSeccion;

    @Override
    public List<Seccion> getAll() {
        return repoSeccion.getAll();
    }

    @Override
    public Seccion getById(Long id) {
        return repoSeccion.getById(id);
    }

    @Override
    public Mensaje save(Seccion seccion) {
        return repoSeccion.save(seccion);
    }

    @Override
    public Mensaje delete(Seccion seccion) {
        return repoSeccion.delete(seccion);
    }
}
