package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Ciudad;
import org.utic.webapp.gestion.entities.Sede;
import org.utic.webapp.gestion.repositories.CiudadRepository;
import org.utic.webapp.gestion.repositories.CrudRepository;
import org.utic.webapp.gestion.repositories.SedeRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class SedeServiceImpl implements SedeService{

    @Inject
    SedeRepository repoSede;

    @Inject
    CiudadRepository repoCiudad;

    @Override
    public List<Sede> getAll() {
        return repoSede.getAll();
    }

    @Override
    public Sede getById(Long id) {
        return repoSede.getById(id);
    }

    @Override
    public Mensaje save(Sede sede) {
        return repoSede.save(sede);
    }

    @Override
    public Mensaje delete(Sede sede) {
        return repoSede.delete(sede);
    }

    @Override
    public List<Ciudad> getCiudadesAll() {
        return repoCiudad.getAll();
    }
}
