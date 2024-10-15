package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.ViewConfirmarClase;
import org.utic.webapp.gestion.repositories.ClaseRepository;
import org.utic.webapp.gestion.repositories.ViewConfirmarClaseRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

@Stateless
public class ViewConfirmarClaseServiceImpl implements ViewConfirmarClaseService{
    @Inject
    ViewConfirmarClaseRepository repo;

    @Inject
    ClaseRepository repoClase;

    @Override
    public List<ViewConfirmarClase> getAllByDocente(Docente docente) {
        return repo.getAllByDocente(docente);
    }

    @Override
    public Mensaje insertClase(ViewConfirmarClase vcc) {
        Clase clase = new Clase();
        clase.setPlanCurso(vcc.getPlanCurso());
        clase.setDocente(vcc.getDocente());
        clase.setAula(vcc.getPlanCursoHorario().getAula());
        clase.setFecha(vcc.getFecha());
        clase.setHorarioDesde(vcc.getPlanCursoHorario().getHorarioDesde());
        clase.setHorarioHasta(vcc.getPlanCursoHorario().getHorarioHasta());

        return repoClase.save(clase);
    }

    @Override
    public List<ViewConfirmarClase> getAll() {
        return repo.getAll();
    }

    @Override
    public ViewConfirmarClase getById(Long id) {
        return repo.getById(id);
    }
}
