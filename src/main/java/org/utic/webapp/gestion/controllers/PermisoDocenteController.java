package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.file.UploadedFile;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.services.PermisoDocenteService;
import org.primefaces.model.file.UploadedFile;

import java.util.List;

@Named
@ViewScoped
public class PermisoDocenteController extends AbstractCrudController<PermisoDocente>{

    private List<Docente> comboDocentes;


    private UploadedFile file;

    @PostConstruct
    public void init() {
        super.init();
        PermisoDocenteService pds = (PermisoDocenteService) super.servicio;
        this.comboDocentes =  pds.getDocentesAll();
    }

    @Override
    protected PermisoDocente createNewInstance() {
        return new PermisoDocente();
    }

    public List<Docente> getComboDocentes() {
        return comboDocentes;
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
