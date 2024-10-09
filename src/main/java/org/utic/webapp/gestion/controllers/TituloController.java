package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Titulo;

@Named
@ViewScoped
public class TituloController extends AbstractCrudController<Titulo>{
    @Override
    protected Titulo createNewInstance() {
        return new Titulo();
    }
}
