package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Alumno;

@Named
@ViewScoped
public class AlumnoController extends AbstractCrudController<Alumno>{
    @Override
    protected Alumno createNewInstance() {
        return new Alumno();
    }

    public String irAInscripcionesMallas() {
        return "inscripciones_mallas?faces-redirect=true";
    }
}
