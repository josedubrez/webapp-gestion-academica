package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.file.UploadedFile;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.SancionAlumno;
import org.utic.webapp.gestion.services.SancionAlumnoService;

import java.util.List;

@Named
@ViewScoped
public class SancionAlumnoController extends AbstractCrudController<SancionAlumno>{

    private List<Alumno> comboAlumnos;
    private List<Malla> comboMallas;

    private UploadedFile file;

    @PostConstruct
    public void init() {
        super.init();
        SancionAlumnoService pds = (SancionAlumnoService) super.servicio;
        this.comboAlumnos =  pds.getAlumnoAll();
        this.comboMallas =  pds.getMallaAll();
    }

    @Override
    protected SancionAlumno createNewInstance() {
        return new SancionAlumno();
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }
    public List<Malla> getComboMallas() {
        return comboMallas;
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
