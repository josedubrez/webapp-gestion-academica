package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.*;

import java.util.List;

@Named
@ViewScoped
public class ReemplazoDocenteController extends  AbstractCrudController<ReemplazoDocente>{
    private List<PlanCurso> comboPlanCurso;
    private List<Docente> comboDocente;

    @Override
    protected ReemplazoDocente createNewInstance() {
        return new ReemplazoDocente();
    }

    @PostConstruct
    public void init() {
        super.init();
        ReemplazoDocenteService ims = (ReemplazoDocenteService) super.servicio;
       this.listado = ims.getAll();
        super.resetSeleccionado();
        this.comboPlanCurso =  ims.getPlanCursoAll();
        this.comboDocente =  ims.getDocentesAll();
    }

    public List<PlanCurso> getComboPlanCurso() {
        return comboPlanCurso;
    }

    public void setComboPlanCurso(List<PlanCurso> comboPlanCurso) {
        this.comboPlanCurso = comboPlanCurso;
    }

    public List<Docente> getComboDocente() {
        return comboDocente;
    }

    public void setComboDocente(List<Docente> comboDocente) {
        this.comboDocente = comboDocente;
    }
}


