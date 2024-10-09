package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Ciudad;

@Named
@ViewScoped
public class CiudadController extends AbstractCrudController<Ciudad> {

    @Override
    protected Ciudad createNewInstance() {
        return new Ciudad();
    }
}
