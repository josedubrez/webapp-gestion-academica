package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.PermisoDocenteService;

import java.util.List;

@Named
@ViewScoped
public class PermisoDocenteController extends AbstractCrudController<PermisoDocente>{

    private List<Docente> comboDocentes;

    @PostConstruct
    public void init() {
        super.init();
        PermisoDocenteService pds = (PermisoDocenteService) super.servicio;
        this.comboDocentes =  pds.getDocentesAll();
    }

    @Override
    protected PermisoDocente createNewInstance() {
        return new PermisoDocente();
    }

    public List<Docente> getComboDocentes() {
        return comboDocentes;
    }
}
