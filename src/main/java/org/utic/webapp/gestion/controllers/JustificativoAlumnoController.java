package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.file.UploadedFile;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.JustificativoAlumno;
import org.utic.webapp.gestion.services.JustificativoAlumnoService;

import java.util.List;

@Named
@ViewScoped
public class JustificativoAlumnoController extends AbstractCrudController<JustificativoAlumno>{

    private List<Alumno> comboAlumnos;

    private UploadedFile file;

    @PostConstruct
    public void init() {
        super.init();
        JustificativoAlumnoService pds = (JustificativoAlumnoService) super.servicio;
        this.comboAlumnos =  pds.getAlumnoAll();
    }

    @Override
    protected JustificativoAlumno createNewInstance() {
        return new JustificativoAlumno();
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
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
