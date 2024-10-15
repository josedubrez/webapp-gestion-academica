package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.ViewConfirmarClase;
import org.utic.webapp.gestion.services.ViewConfirmarClaseService;
import org.utic.webapp.gestion.utils.Mensaje;

@Named
@ViewScoped
public class ViewConfirmarClaseController extends AbstractViewController<ViewConfirmarClase>{

    @PostConstruct
    public void init() {
        ViewConfirmarClaseService vccs = (ViewConfirmarClaseService) super.servicio;
        super.listado = vccs.getAllByDocente(super.vUsuario.getRegistro().getDocente());
    }

    public void insertClase() {
        ViewConfirmarClaseService vccs = (ViewConfirmarClaseService) super.servicio;
        Mensaje mensaje = vccs.insertClase(super.registro);
        super.registro = null;

        if (mensaje != null) {
            if (mensaje.isRealizado()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase confirmada con exito!!!", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje.getTitulo(), mensaje.getDetalle());
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");

        this.init();
    }
}
