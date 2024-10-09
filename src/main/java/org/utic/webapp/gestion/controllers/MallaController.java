package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;

import java.util.List;

import jakarta.inject.Named;

import org.utic.webapp.gestion.entities.Carrera;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.services.MallaService;

@Named
@ViewScoped
public class MallaController extends AbstractCrudController<Malla> {

    private List<Carrera> comboCarreras;

    @PostConstruct
    public void init() {
        super.init();
        MallaService ms = (MallaService) super.servicio;
        this.comboCarreras =  ms.getCarrerasAll();
    }

    @Override
    protected Malla createNewInstance() {
        return new Malla();
    }

    public List<Carrera> getComboCarreras() {
        return comboCarreras;
    }

    public String irADetalleMalla() {
        return "mallas_det?faces-redirect=true";
    }

    public String irAEscalaCalificacion() {
        return "escalas_calificaciones?faces-redirect=true";
    }

    public String irARequisitosInscripciones() {
        return "requisitos_inscripciones?faces-redirect=true";
    }
}