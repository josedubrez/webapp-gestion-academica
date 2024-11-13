package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.TrabajoClaseDet;
import org.utic.webapp.gestion.services.TrabajoClaseDetService;
import org.utic.webapp.gestion.utils.Mensaje;

@Named
@ViewScoped
public class MisTrabajoClaseDetController extends AbstractCrudController<TrabajoClaseDet>{
    @Override
    protected TrabajoClaseDet createNewInstance() {
        return new TrabajoClaseDet();
    }

    @PostConstruct
    public void init() {
        TrabajoClaseDetService tcds = (TrabajoClaseDetService) super.servicio;
        super.listado = tcds.getAllByTrabajoClase(filtrador.getFiltroTrabajoClase());
    }

    public void guardarCambios(){
        TrabajoClaseDetService tcds = (TrabajoClaseDetService) super.servicio;
        Mensaje mensaje = new Mensaje(false, "", "");
        boolean procesado_ok = true;

        if (super.listado != null && !super.listado.isEmpty()){
            for (TrabajoClaseDet tpd: super.listado){
                mensaje = tcds.save(tpd);
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

    public String volverATrabajoClase() {
        return "mis_trabajos_clases?faces-redirect=true";
    }
}


