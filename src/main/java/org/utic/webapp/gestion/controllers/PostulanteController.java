package org.utic.webapp.gestion.controllers;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Postulante;

@Named
@ViewScoped
public class PostulanteController extends AbstractCrudController<Postulante>{
    @Override
    protected Postulante createNewInstance() {
        return new Postulante();
    }

    public String irARequisitosDocentesDet() {
        return "requisitos_docentes_det?faces-redirect=true";
    }
}
