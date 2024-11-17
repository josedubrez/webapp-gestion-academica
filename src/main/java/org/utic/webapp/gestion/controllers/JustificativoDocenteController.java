package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.file.UploadedFile;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.JustificativoDocente;
import org.utic.webapp.gestion.entities.PermisoDocente;
import org.utic.webapp.gestion.services.JustificativoDocenteService;
import org.utic.webapp.gestion.services.PermisoDocenteService;

import java.util.List;

@Named
@ViewScoped
public class JustificativoDocenteController extends AbstractCrudController<JustificativoDocente>{

    private List<Docente> comboDocentes;

    private UploadedFile file;

    @PostConstruct
    public void init() {
        super.init();
        JustificativoDocenteService pds = (JustificativoDocenteService) super.servicio;
        this.comboDocentes =  pds.getDocentesAll();
    }

    @Override
    protected JustificativoDocente createNewInstance() {
        return new JustificativoDocente();
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
