package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.PlanCursoHorarioService;

import java.util.List;

@Named
@ViewScoped
public class PlanCursoHorarioController extends AbstractCrudController<PlanCursoHorario>{
    private List<Aula> comboAulas;
    private List<DiaSemana> comboDiasSemana;

    public List<Aula> getComboAulas() {
        return comboAulas;
    }

    public List<DiaSemana> getComboDiasSemana() {
        return comboDiasSemana;
    }

    @PostConstruct
    public void init() {
        PlanCursoHorarioService pchs = (PlanCursoHorarioService) super.servicio;
        this.listado = pchs.getPlanesCursosHorariosAllByPlanCurso(filtrador.getFiltroPlanCurso());
        super.resetSeleccionado();
        this.comboAulas =  pchs.getAulasAll();
        this.comboDiasSemana = pchs.getDiasSemanaAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setPlanCurso(filtrador.getFiltroPlanCurso());
    }

    @Override
    protected PlanCursoHorario createNewInstance() {
        return new PlanCursoHorario();
    }

    public String volverAPlanCurso() {
        return "planes_cursos?faces-redirect=true";
    }
}
