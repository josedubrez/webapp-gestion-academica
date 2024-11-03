package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.TrabajoPractico;
import org.utic.webapp.gestion.services.TrabajoPracticoService;

@Named
@ViewScoped
public class TrabajoPracticoController extends AbstractCrudController<TrabajoPractico>{
    @Override
    protected TrabajoPractico createNewInstance() {
        return new TrabajoPractico();
    }

    @PostConstruct
    public void init() {
        TrabajoPracticoService tps = (TrabajoPracticoService) super.servicio;
        this.listado = tps.getAllByPlanCurso(filtrador.getFiltroPlanCurso());
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

    public String irAMisTrabajosPracticosDet() {
        return "mis_trabajos_practicos_det?faces-redirect=true";
    }
}
