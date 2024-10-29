package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.services.ExamenService;

@Named
@ViewScoped
public class ExamenController extends AbstractCrudController<Examen>{
    @Override
    protected Examen createNewInstance() {
        return new Examen();
    }

    @PostConstruct
    public void init() {
        ExamenService es = (ExamenService) super.servicio;
        this.listado = es.getAllByPlanCurso(filtrador.getFiltroPlanCurso());
        super.resetSeleccionado();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setPlanCurso(filtrador.getFiltroPlanCurso());
    }

    public String volverAPlanCurso() {
        return "planes_cursos?faces-redirect=true";
    }

    public String volverAMisPlanesCursos() {
        return "mis_planes_cursos?faces-redirect=true";
    }
}
