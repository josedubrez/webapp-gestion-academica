package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.AulaService;

import java.util.List;

@Named
@ViewScoped
public class AulaController extends AbstractCrudController<Aula>{

    private List<Piso> comboPisos;
    private List<Seccion> comboSecciones;

    @PostConstruct
    public void init() {
        super.init();
        AulaService as = (AulaService) super.servicio;
        this.comboPisos =  as.getPisosAll();
        this.comboSecciones =  as.getSeccionesAll();
    }

    @Override
    protected Aula createNewInstance() {
        return new Aula();
    }

    public List<Piso> getComboPisos() {
        return comboPisos;
    }

    public List<Seccion> getComboSecciones() {
        return comboSecciones;
    }
}