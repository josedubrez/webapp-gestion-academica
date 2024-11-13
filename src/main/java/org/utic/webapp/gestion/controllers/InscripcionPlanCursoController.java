package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.*;

import java.util.List;

@Named
@ViewScoped
public class InscripcionPlanCursoController extends  AbstractCrudController<InscripcionPlanCurso>{
    private List<PlanCurso> comboPlanCurso;
    private List<Alumno> comboAlumnos;

    @Override
    protected InscripcionPlanCurso createNewInstance() {
        return new InscripcionPlanCurso();
    }

    @PostConstruct
    public void init() {
        InscripcionPlanCursoService ims = (InscripcionPlanCursoService) super.servicio;
        this.listado = ims.getAllByAlumno(filtrador.getFiltroAlumno());
        super.resetSeleccionado();
        this.comboPlanCurso =  ims.getPlanCursoAll();
        this.comboAlumnos = ims.getAlumnoAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setAlumno(filtrador.getFiltroAlumno());
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }

    public void setComboAlumnos(List<Alumno> comboAlumnos) {
        this.comboAlumnos = comboAlumnos;
    }
    public String volverAAlumno() {
        return "alumnos?faces-redirect=true";
    }

    public List<PlanCurso> getComboPlanCurso() {
        return comboPlanCurso;
    }

    public void setComboPlanCurso(List<PlanCurso> comboPlanCurso) {
        this.comboPlanCurso = comboPlanCurso;
    }
}


