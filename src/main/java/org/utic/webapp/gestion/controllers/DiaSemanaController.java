package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.DiaSemana;

@Named
@ViewScoped
public class DiaSemanaController extends AbstractCrudController<DiaSemana>{
    @Override
    protected DiaSemana createNewInstance() {
        return new DiaSemana();
    }
}
