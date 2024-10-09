package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Materia;

@Named
@ViewScoped
public class MateriaController extends AbstractCrudController<Materia> {

    @Override
    protected Materia createNewInstance() {
        return new Materia();
    }
}
