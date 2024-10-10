package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Rol;

@Named
@ViewScoped
public class RolController extends AbstractCrudController<Rol>{
    @Override
    protected Rol createNewInstance() {
        return new Rol();
    }
}
