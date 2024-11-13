package org.utic.webapp.gestion.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Calificacion;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.ViewCalificacionPendiente;
import org.utic.webapp.gestion.repositories.CalificacionRepository;
import org.utic.webapp.gestion.repositories.ViewCalificacionPendienteRepository;
import org.utic.webapp.gestion.utils.Mensaje;

import java.time.LocalDate;
import java.util.List;

@Stateless
public class ViewCalificacionPendienteServiceImpl implements ViewCalificacionPendienteService{

    @Inject
    private ViewCalificacionPendienteRepository repo;

    @Inject
    private CalificacionRepository repoCalificacion;

    @Override
    public List<ViewCalificacionPendiente> getAllByDocente(Docente docente) {
        return repo.getAllByDocente(docente);
    }

    @Override
    public Mensaje insertCalificacion(ViewCalificacionPendiente vcp) {
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        Calificacion calificacion = new Calificacion();
        calificacion.setPlanCurso(vcp.getPlanCurso());
        calificacion.setAlumno(vcp.getAlumno());
        calificacion.setFecha(LocalDate.now());
        calificacion.setPuntajeTrabajosClases(vcp.getPuntajeTrabajosClases());
        calificacion.setPuntajeTrabajoPractico(vcp.getPuntajeTrabajoPractico());
        calificacion.setPuntajeExamenParcial(vcp.getPuntajeExamenParcial());
        calificacion.setPuntajeExamenFinal(vcp.getPuntajeExamenFinal());
        calificacion.setCalificacion(vcp.getCalificacion());
        calificacion.setFelicitado(vcp.getFelicitado());
        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC " + repoCalificacion);

        return repoCalificacion.save(calificacion);
    }

    @Override
    public List<ViewCalificacionPendiente> getAll() {
        return repo.getAll();
    }

    @Override
    public ViewCalificacionPendiente getById(Long id) {
        return repo.getById(id);
    }
}
