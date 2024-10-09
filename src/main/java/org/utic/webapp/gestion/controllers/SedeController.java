package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.SedeService;

import java.util.List;

@Named
@ViewScoped
public class SedeController extends AbstractCrudController<Sede>{
    private List<Ciudad> comboCiudades;

    @PostConstruct
    public void init() {
        super.init();
        SedeService ms = (SedeService) super.servicio;
        this.comboCiudades =  ms.getCiudadesAll();
    }

    @Override
    protected Sede createNewInstance() {
        return new Sede();
    }

    public List<Ciudad> getComboCiudades() {
        return comboCiudades;
    }
}
