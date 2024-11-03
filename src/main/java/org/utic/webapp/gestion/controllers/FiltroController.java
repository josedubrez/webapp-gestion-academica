package org.utic.webapp.gestion.controllers;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.*;
import java.io.Serializable;

@Named
@SessionScoped
public class FiltroController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Malla filtroMalla;
    private MallaDet filtroMallaDet;
    private Docente filtroDocente;
    private PlanCurso filtroPlanCurso;
    private Alumno filtroAlumno;
    private Postulante filtroPostulante;
    private Usuario filtroUsuario;
    private Clase filtroClase;
    private TrabajoPractico filtroTrabajoPractico;
    private Examen filtroExamen;

    public Malla getFiltroMalla() {
        return filtroMalla;
    }

    public void setFiltroMalla(Malla filtroMalla) {
        this.filtroMalla = filtroMalla;
    }

    public MallaDet getFiltroMallaDet() {
        return filtroMallaDet;
    }

    public void setFiltroMallaDet(MallaDet filtroMallaDet) {
        this.filtroMallaDet = filtroMallaDet;
    }

    public Docente getFiltroDocente() {
        return filtroDocente;
    }

    public void setFiltroDocente(Docente filtroDocente) {
        this.filtroDocente = filtroDocente;
    }

    public PlanCurso getFiltroPlanCurso() {
        return filtroPlanCurso;
    }

    public void setFiltroPlanCurso(PlanCurso filtroPlanCurso) {
        this.filtroPlanCurso = filtroPlanCurso;
    }

    public Alumno getFiltroAlumno() {
        return filtroAlumno;
    }

    public void setFiltroAlumno(Alumno filtroAlumno) {
        this.filtroAlumno = filtroAlumno;
    }

    public Postulante getFiltroPostulante() {
        return filtroPostulante;
    }

    public void setFiltroPostulante(Postulante filtroPostulante) {
        this.filtroPostulante = filtroPostulante;
    }

    public Usuario getFiltroUsuario() {
        return filtroUsuario;
    }

    public void setFiltroUsuario(Usuario filtroUsuario) {
        this.filtroUsuario = filtroUsuario;
    }

    public Clase getFiltroClase() {
        return filtroClase;
    }

    public void setFiltroClase(Clase filtroClase) {
        this.filtroClase = filtroClase;
    }

    public TrabajoPractico getFiltroTrabajoPractico() {
        return filtroTrabajoPractico;
    }

    public void setFiltroTrabajoPractico(TrabajoPractico filtroTrabajoPractico) {
        this.filtroTrabajoPractico = filtroTrabajoPractico;
    }

    public Examen getFiltroExamen() {
        return filtroExamen;
    }

    public void setFiltroExamen(Examen filtroExamen) {
        this.filtroExamen = filtroExamen;
    }
}
