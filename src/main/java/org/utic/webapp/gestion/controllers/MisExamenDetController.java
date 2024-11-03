package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.ExamenDet;
import org.utic.webapp.gestion.services.ExamenDetService;
import org.utic.webapp.gestion.utils.Mensaje;

@Named
@ViewScoped
public class MisExamenDetController extends AbstractCrudController<ExamenDet>{
    @Override
    protected ExamenDet createNewInstance() {
        return new ExamenDet();
    }

    @PostConstruct
    public void init() {
        ExamenDetService eds = (ExamenDetService) super.servicio;
        super.listado = eds.getAllByExamen(filtrador.getFiltroExamen());
    }

    public void guardarCambios(){
        ExamenDetService eds = (ExamenDetService) super.servicio;
        Mensaje mensaje = new Mensaje(false, "", "");
        boolean procesado_ok = true;

        if (super.listado != null && !super.listado.isEmpty()){
            for (ExamenDet ed: super.listado){
                mensaje = eds.save(ed);
                if (!mensaje.isRealizado()){
                    procesado_ok = false;
                    break;
                }
            }
        }

        if (procesado_ok) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se guardaron los cambios con exito!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje.getTitulo(), mensaje.getDetalle());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
        this.init();
    }

    public String volverATrabajoPractico() {
        return "mis_examenes?faces-redirect=true";
    }
}
