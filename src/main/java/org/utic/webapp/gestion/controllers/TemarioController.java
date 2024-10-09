package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Temario;
import org.utic.webapp.gestion.services.TemarioService;

import java.util.List;

@Named
@ViewScoped
public class TemarioController extends AbstractCrudController<Temario>{

    private List<Temario> comboTemarios;

    @Override
    protected Temario createNewInstance() {
        return new Temario();
    }

    @PostConstruct
    public void init() {
        TemarioService mds = (TemarioService) super.servicio;
        this.listado = mds.getTemariosAllByMallaDet(filtrador.getFiltroMallaDet());
        super.resetSeleccionado();
        this.comboTemarios = this.listado;
        System.out.println("TEMARIO_CONTROLLER.INIT: " + this + " " + filtrador.getFiltroMallaDet());
    }

    @Override
    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setMallaDet(filtrador.getFiltroMallaDet());
    }

    public List<Temario> getComboTemarios() {
        return comboTemarios;
    }

    public String irAMallaDet() {
        return "mallas_det?faces-redirect=true";
    }
}
