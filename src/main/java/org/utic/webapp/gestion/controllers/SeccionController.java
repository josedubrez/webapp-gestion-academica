package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Seccion;

@Named
@ViewScoped
public class SeccionController extends AbstractCrudController<Seccion>{
    @Override
    protected Seccion createNewInstance() {
        return new Seccion();
    }
}