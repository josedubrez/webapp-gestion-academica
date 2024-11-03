package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Requisito;
import org.utic.webapp.gestion.entities.RequisitoInscripcion;
import org.utic.webapp.gestion.services.RequisitoInscripcionService;

import java.util.List;

@Named
@ViewScoped
public class RequisitoInscripcionController extends AbstractCrudController<RequisitoInscripcion>{

    private List<Requisito> comboRequisitos;

    @Override
    protected RequisitoInscripcion createNewInstance() {
        return new RequisitoInscripcion();
    }

    @PostConstruct
    public void init() {
        RequisitoInscripcionService ris = (RequisitoInscripcionService) super.servicio;
        this.listado = ris.getAllByMalla(filtrador.getFiltroMalla());
        super.resetSeleccionado();
        this.comboRequisitos =  ris.getRequisitoAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setMalla(filtrador.getFiltroMalla());
    }

    public List<Requisito> getComboRequisitos() {
        return comboRequisitos;
    }

    public String volverAMalla() {
        return "mallas?faces-redirect=true";
    }
}
