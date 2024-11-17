package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.file.UploadedFile;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.ReqInscripcionAlumnoService;

import java.util.List;

@Named
@ViewScoped
public class ReqInscripcionAlumnoController extends  AbstractCrudController<ReqInscripcionAlumno>{
    private List<Requisito> comboRequisito;
    private List<Alumno> comboAlumnos;

    private UploadedFile file;

    @Override
    protected ReqInscripcionAlumno createNewInstance() {
        return new ReqInscripcionAlumno();
    }

    @PostConstruct
    public void init() {
        ReqInscripcionAlumnoService ims = (ReqInscripcionAlumnoService) super.servicio;
        this.listado = ims.getAllByAlumno(filtrador.getFiltroAlumno());
        super.resetSeleccionado();
        this.comboRequisito =  ims.getRequisitoAll();
        this.comboAlumnos = ims.getAlumnoAll();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setAlumno(filtrador.getFiltroAlumno());
    }

    public List<Requisito> getComboRequisito() {
        return comboRequisito;
    }

    public void setComboRequisito(List<Requisito> comboRequisito) {
        this.comboRequisito = comboRequisito;
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }

    public void setComboAlumnos(List<Alumno> comboAlumnos) {
        this.comboAlumnos = comboAlumnos;
    }
    public String volverAAlumno() {
        return "alumnos?faces-redirect=true";
    }

    public UploadedFile getFile() {
        return file;
    }
    public void setFile(UploadedFile file) {
        this.file = file;
        if (file != null){
            super.seleccionado.setDirArchivo(this.file.getFileName());
        }
    }
}


