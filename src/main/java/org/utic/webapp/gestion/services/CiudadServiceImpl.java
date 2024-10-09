package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Ciudad;
import org.utic.webapp.gestion.repositories.CiudadRepository;
import org.utic.webapp.gestion.repositories.CrudRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class CiudadServiceImpl implements CiudadService{

    @Inject
    CiudadRepository repoCiudad;

    @Override
    public List<Ciudad> getAll() {
        return repoCiudad.getAll();
    }

    @Override
    public Ciudad getById(Long id) {
        return repoCiudad.getById(id);
    }

    @Override
    public Mensaje save(Ciudad ciudad) {
        return repoCiudad.save(ciudad);
    }

    @Override
    public Mensaje delete(Ciudad ciudad) {
        return repoCiudad.delete(ciudad);
    }
}
