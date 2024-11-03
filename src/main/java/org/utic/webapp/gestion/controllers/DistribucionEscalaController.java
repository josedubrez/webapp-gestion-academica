package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.DistribucionEscala;
import org.utic.webapp.gestion.services.DistribucionEscalaService;

@Named
@ViewScoped
public class DistribucionEscalaController extends AbstractCrudController<DistribucionEscala>{
    @Override
    protected DistribucionEscala createNewInstance() {
        return new DistribucionEscala();
    }

    @PostConstruct
    public void init() {
        DistribucionEscalaService des = (DistribucionEscalaService) super.servicio;
        this.listado = des.getAllByPlanCurso(filtrador.getFiltroPlanCurso());
        super.resetSeleccionado();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setPlanCurso(filtrador.getFiltroPlanCurso());
    }

    public String volverAPlanCurso() {
        return "planes_cursos?faces-redirect=true";
    }

    public String volverAMisPlanCurso() {
        return "mis_planes_cursos?faces-redirect=true";
    }
}
