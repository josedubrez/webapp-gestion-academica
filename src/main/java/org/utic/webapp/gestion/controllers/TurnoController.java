package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Turno;

@Named
@ViewScoped
public class TurnoController extends AbstractCrudController<Turno>{
    @Override
    protected Turno createNewInstance() {
        return new Turno();
    }
}