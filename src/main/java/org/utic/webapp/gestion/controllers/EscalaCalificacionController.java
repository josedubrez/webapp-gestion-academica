package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.EscalaCalificacion;
import org.utic.webapp.gestion.services.EscalaCalificacionService;
import org.utic.webapp.gestion.services.MallaDetService;

@Named
@ViewScoped
public class EscalaCalificacionController extends AbstractCrudController<EscalaCalificacion>{
    @Override
    protected EscalaCalificacion createNewInstance() {
        return new EscalaCalificacion();
    }

    @PostConstruct
    public void init() {
        EscalaCalificacionService ecs = (EscalaCalificacionService) super.servicio;
        this.listado = ecs.getAllByMalla(filtrador.getFiltroMalla());
        super.resetSeleccionado();
        System.out.println("ESCALA_CALIFICACION_CONTROLLER.INIT: " + this + " " + filtrador.getFiltroMalla());
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setMalla(filtrador.getFiltroMalla());
    }

    public String volverAMalla() {
        return "mallas?faces-redirect=true";
    }
}
