package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.MallaDetService;

import java.util.List;

@Named
@ViewScoped
public class MallaDetController extends AbstractCrudController<MallaDet>{

    private List<Materia> comboMaterias;
    private List<MallaDet> comboMallasDet;

    @Override
    protected MallaDet createNewInstance() {
        return new MallaDet();
    }

    @PostConstruct
    public void init() {
        MallaDetService mds = (MallaDetService) super.servicio;
        this.listado = mds.getAllByMalla(filtrador.getFiltroMalla());
        super.resetSeleccionado();
        this.comboMaterias =  mds.getMateriasAll();
        this.comboMallasDet = this.listado;
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setMalla(filtrador.getFiltroMalla());
    }

    public List<MallaDet> getComboMallasDet() {
        return comboMallasDet;
    }

    public List<Materia> getComboMaterias() {
        return comboMaterias;
    }

    public String irAMalla() {
        return "mallas?faces-redirect=true";
    }

    public String irATemarios() {
        return "temarios?faces-redirect=true";
    }
}
