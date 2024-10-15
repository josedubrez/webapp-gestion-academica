package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.services.PlanCursoService;

@Named
@ViewScoped
public class MisPlanCursoController extends AbstractCrudController<PlanCurso>{

    @Inject
    private ViewPermisoUsuarioController vUsuario;

    @Override
    protected PlanCurso createNewInstance() {
        return new PlanCurso();
    }

    @PostConstruct
    public void init() {
        PlanCursoService pcs = (PlanCursoService) super.servicio;
        this.listado = pcs.getAllByDocente(vUsuario.getRegistro().getDocente());
    }
}
