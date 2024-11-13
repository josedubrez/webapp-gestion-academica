package org.utic.webapp.gestion.controllers;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Requisito;

@Named
@ViewScoped
public class RequisitosController extends AbstractCrudController<Requisito>{
    @Override
    protected Requisito createNewInstance() {
        return new Requisito();
    }
    }
