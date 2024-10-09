package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.RequisitoInscripcion;
import org.utic.webapp.gestion.services.RequisitoInscripcionService;

@Named
@ViewScoped
public class RequisitoInscripcionController extends AbstractCrudController<RequisitoInscripcion>{
    @Override
    protected RequisitoInscripcion createNewInstance() {
        return new RequisitoInscripcion();
    }

    @PostConstruct
    public void init() {
        RequisitoInscripcionService ris = (RequisitoInscripcionService) super.servicio;
        this.listado = ris.getAllByMalla(filtrador.getFiltroMalla());
        super.resetSeleccionado();
        System.out.println("REQUISITO_INSCRIPCION_CONTROLLER.INIT: " + this + " " + filtrador.getFiltroMalla());
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setMalla(filtrador.getFiltroMalla());
    }

    public String volverAMalla() {
        return "mallas?faces-redirect=true";
    }
}
