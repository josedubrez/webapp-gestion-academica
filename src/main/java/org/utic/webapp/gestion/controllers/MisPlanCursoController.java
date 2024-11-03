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

    public String irAMisHorarios() {
        return "mis_planes_cursos_horarios?faces-redirect=true";
    }

    public String irAMisTrabajosPracticos() {
        return "mis_trabajos_practicos?faces-redirect=true";
    }

    public String irAMisExamenes(){
        return "mis_examenes?faces-redirect=true";
    }

    public String irAMisDistribucionesPuntajes(){
        return "mis_distribuciones_escalas?faces-redirect=true";
    }
}
