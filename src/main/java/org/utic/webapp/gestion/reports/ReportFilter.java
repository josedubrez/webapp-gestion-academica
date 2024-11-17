package org.utic.webapp.gestion.reports;

import jakarta.enterprise.inject.Model;
import org.utic.webapp.gestion.entities.*;

import java.time.LocalDate;

@Model
public class ReportFilter {
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private Integer nroSemestre;
    private Malla malla;
    private MallaDet mallaDet;
    private Docente docente;
    private PlanCurso planCurso;
    private Alumno alumno;

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public Malla getMalla() {
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public MallaDet getMallaDet() {
        return mallaDet;
    }

    public void setMallaDet(MallaDet mallaDet) {
        this.mallaDet = mallaDet;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public PlanCurso getPlanCurso() {
        return planCurso;
    }

    public void setPlanCurso(PlanCurso planCurso) {
        this.planCurso = planCurso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getNroSemestre() {
        return nroSemestre;
    }

    public void setNroSemestre(Integer nroSemestre) {
        this.nroSemestre = nroSemestre;
    }
}
