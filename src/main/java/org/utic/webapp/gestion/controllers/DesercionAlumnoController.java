package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.file.UploadedFile;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.DesercionAlumno;
import org.utic.webapp.gestion.services.DesercionAlumnoService;

import java.util.List;

@Named
@ViewScoped
public class DesercionAlumnoController extends AbstractCrudController<DesercionAlumno>{

    private List<Alumno> comboAlumnos;
    private List<Malla> comboMallas;


    @PostConstruct
    public void init() {
        super.init();
        DesercionAlumnoService pds = (DesercionAlumnoService) super.servicio;
        this.comboAlumnos =  pds.getAlumnoAll();
        this.comboMallas =  pds.getMallaAll();
    }

    @Override
    protected DesercionAlumno createNewInstance() {
        return new DesercionAlumno();
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }
    public List<Malla> getComboMallas() {
        return comboMallas;
    }

}
