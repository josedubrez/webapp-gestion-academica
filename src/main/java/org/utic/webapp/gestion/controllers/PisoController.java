package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Piso;

@Named
@ViewScoped
public class PisoController extends AbstractCrudController<Piso>{
    @Override
    protected Piso createNewInstance() {
        return new Piso();
    }
}
