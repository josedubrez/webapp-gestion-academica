package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.RequisitoDocente;
import org.utic.webapp.gestion.entities.RequisitoDocenteDet;
import org.utic.webapp.gestion.services.RequisitoDocenteDetService;

import java.util.List;

@Named
@ViewScoped
public class RequisitoDocenteDetController extends AbstractCrudController<RequisitoDocenteDet>{
    private List<RequisitoDocente> comboRequisitosDocentes;

    @Override
    protected RequisitoDocenteDet createNewInstance() {
        return new RequisitoDocenteDet();
    }

    @PostConstruct
    public void init() {
        RequisitoDocenteDetService rdds = (RequisitoDocenteDetService) super.servicio;
        this.listado = rdds.getAllByPostulante(filtrador.getFiltroPostulante());
        super.resetSeleccionado();
        this.comboRequisitosDocentes =  rdds.getRequisitosDocentesAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setPostulante(filtrador.getFiltroPostulante());
    }

    public List<RequisitoDocente> getComboRequisitosDocentes() {
        return comboRequisitosDocentes;
    }

    public String volverAPostulante() {
        return "postulantes?faces-redirect=true";
    }
}
