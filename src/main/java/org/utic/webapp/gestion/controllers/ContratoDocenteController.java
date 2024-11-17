package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.ContratoDocente;
import org.utic.webapp.gestion.services.ContratoDocenteService;
import org.primefaces.model.file.UploadedFile;

@Named
@ViewScoped
public class ContratoDocenteController extends AbstractCrudController<ContratoDocente>{
    @Override
    protected ContratoDocente createNewInstance() {
        return new ContratoDocente();
    }
    private UploadedFile file;
    @PostConstruct
    public void init() {
        ContratoDocenteService cds = (ContratoDocenteService) super.servicio;
        this.listado = cds.getContratosDocentesAllByDocente(filtrador.getFiltroDocente());
        super.resetSeleccionado();
        System.out.println("CONTRATO_DOCENTE_CONTROLLER.INIT: " + this + " " + filtrador.getFiltroDocente());
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setDocente(filtrador.getFiltroDocente());
    }

    public String volverADocente() {
        return "docentes?faces-redirect=true";
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
