package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Feriado;
import org.utic.webapp.gestion.entities.Sede;
import org.utic.webapp.gestion.services.FeriadoService;
import org.utic.webapp.gestion.services.PlanCursoService;

import java.util.List;

@Named
@ViewScoped
public class FeriadoController extends AbstractCrudController<Feriado>{

    private List<Sede> comboSedes;

    @Override
    protected Feriado createNewInstance() {
        return new Feriado();
    }

    @PostConstruct
    public void init() {
        super.init();
        FeriadoService fs = (FeriadoService) super.servicio;
        this.comboSedes = fs.getSedesAll();
    }

    public List<Sede> getComboSedes() {
        return comboSedes;
    }

    public void setComboSedes(List<Sede> comboSedes) {
        this.comboSedes = comboSedes;
    }
}
