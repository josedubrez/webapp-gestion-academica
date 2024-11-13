package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Calificacion;
import org.utic.webapp.gestion.services.CalificacionService;
import org.utic.webapp.gestion.services.ClaseService;

@Named
@ViewScoped
public class CalificacionController extends AbstractCrudController<Calificacion>{
    @Override
    protected Calificacion createNewInstance() {
        return new Calificacion();
    }

    @PostConstruct
    public void init() {
        CalificacionService cs = (CalificacionService) super.servicio;
        this.listado = cs.getAllByPlanCurso(filtrador.getFiltroPlanCurso());
    }

    public String volverAPlanCurso() {
        return "planes_cursos?faces-redirect=true";
    }

    public String volverAMisPlanesCursos() {
        return "mis_planes_cursos?faces-redirect=true";
    }
}
