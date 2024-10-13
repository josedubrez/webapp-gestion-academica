package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.InscripcionMallaService;

import java.util.List;
@Named
@ViewScoped
public class inscripcionController extends  AbstractCrudController<InscripcionMalla>{
    private List<Malla> comboMallas;
    private List<Sede> comboSedes;
    private List<Turno> comboTurnos;
    private List<Alumno> comboAlumnos;

    @Override
    protected InscripcionMalla createNewInstance() {
        return new InscripcionMalla();
    }

    @PostConstruct
    public void init() {
        super.init();
        InscripcionMallaService ims = (InscripcionMallaService) super.servicio;
        super.resetSeleccionado();
        this.comboMallas =  ims.getMallasAll();
        this.comboSedes = ims.getSedesAll();
        this.comboTurnos = ims.getTurnosAll();
        this.comboAlumnos = ims.getAlumnoAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
    }

    public List<Malla> getComboMallas() {
        return comboMallas;
    }

    public List<Sede> getComboSedes() {
        return comboSedes;
    }

    public List<Turno> getComboTurnos() {
        return comboTurnos;
    }
    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }

    public String volverAAlumno() {
        return "alumnos?faces-redirect=true";
    }
}


