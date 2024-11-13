package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.services.ClaseService;

@Named
@ViewScoped
public class ClaseController extends AbstractCrudController<Clase>{
    @Override
    protected Clase createNewInstance() {
        return new Clase();
    }

    @PostConstruct
    public void init() {
        ClaseService cs = (ClaseService) super.servicio;
        this.listado = cs.getAllByPlanCurso(filtrador.getFiltroPlanCurso());
    }

    public String volverAPlanCurso() {
        return "planes_cursos?faces-redirect=true";
    }

    public String volverAMisPlanesCursos() {
        return "mis_planes_cursos?faces-redirect=true";
    }

    public String irAMisTrabajosClases() {
        return "mis_trabajos_clases?faces-redirect=true";
    }

    public String irAMisAsistencias() {
        return "mis_asistencias?faces-redirect=true";
    }
}
