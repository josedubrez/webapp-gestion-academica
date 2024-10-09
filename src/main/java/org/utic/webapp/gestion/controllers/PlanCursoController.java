package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.PlanCursoService;

import java.util.List;

@Named
@ViewScoped
public class PlanCursoController extends AbstractCrudController<PlanCurso>{

    private List<Sede> comboSedes;
    private List<Turno> comboTurnos;
    private List<Docente> comboDocentes;
    private List<MallaDet> comboMallasDet;

    @PostConstruct
    public void init() {
        super.init();
        PlanCursoService pcs = (PlanCursoService) super.servicio;
        this.comboDocentes =  pcs.getDocentesAll();
        this.comboSedes = pcs.getSedesAll();
        this.comboTurnos = pcs.getTurnosAll();
        this.comboMallasDet = pcs.getMallasDetAll();
    }

    @Override
    protected PlanCurso createNewInstance() {
        return new PlanCurso();
    }

    public List<Sede> getComboSedes() {
        return comboSedes;
    }

    public List<Turno> getComboTurnos() {
        return comboTurnos;
    }

    public List<Docente> getComboDocentes() {
        return comboDocentes;
    }

    public List<MallaDet> getComboMallasDet() {
        return comboMallasDet;
    }

    public String irAHorarios() {
        return "planes_cursos_horarios?faces-redirect=true";
    }

    public String irATrabajosPracticos() {
        return "trabajos_practicos?faces-redirect=true";
    }
}
