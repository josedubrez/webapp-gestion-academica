package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.InscripcionMallaService;

import java.util.List;

@Named
@ViewScoped
public class InscripcionMallaController extends AbstractCrudController<InscripcionMalla>{

    private List<Malla> comboMallas;
    private List<Sede> comboSedes;
    private List<Turno> comboTurnos;

    @Override
    protected InscripcionMalla createNewInstance() {
        return new InscripcionMalla();
    }

    @PostConstruct
    public void init() {
        InscripcionMallaService ims = (InscripcionMallaService) super.servicio;
        this.listado = ims.getAllByAlumno(filtrador.getFiltroAlumno());
        super.resetSeleccionado();
        this.comboMallas =  ims.getMallasAll();
        this.comboSedes = ims.getSedesAll();
        this.comboTurnos = ims.getTurnosAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setAlumno(filtrador.getFiltroAlumno());
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

    public String volverAAlumno() {
        return "alumnos?faces-redirect=true";
    }
}
