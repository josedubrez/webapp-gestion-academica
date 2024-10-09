package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.Titulo;
import org.utic.webapp.gestion.services.DocenteService;

import java.util.List;

@Named
@ViewScoped
public class DocenteController extends AbstractCrudController<Docente>{

    private List<Titulo> comboTitulos;

    @Override
    protected Docente createNewInstance() {
        return new Docente();
    }

    @PostConstruct
    public void init() {
        super.init();
        DocenteService ms = (DocenteService) super.servicio;
        this.comboTitulos =  ms.getTitulosAll();
    }

    public List<Titulo> getComboTitulos() {
        return comboTitulos;
    }

    public void setComboTitulos(List<Titulo> comboTitulos) {
        this.comboTitulos = comboTitulos;
    }

    public String irAContratos() {
        return "contratos_docentes?faces-redirect=true";
    }
}
