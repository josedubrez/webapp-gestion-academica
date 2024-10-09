package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.RequisitoDocente;

@Named
@ViewScoped
public class RequisitoDocenteController extends AbstractCrudController<RequisitoDocente>{
    @Override
    protected RequisitoDocente createNewInstance() {
        return new RequisitoDocente();
    }
}
