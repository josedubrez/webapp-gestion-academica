package org.utic.webapp.gestion.controllers;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Carrera;

@Named
@ViewScoped
public class CarreraController extends AbstractCrudController<Carrera> {
    @Override
    protected Carrera createNewInstance() {
        return new Carrera();
    }
}