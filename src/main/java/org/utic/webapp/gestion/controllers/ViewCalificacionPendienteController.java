package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.ViewCalificacionPendiente;
import org.utic.webapp.gestion.services.ViewCalificacionPendienteService;
import org.utic.webapp.gestion.utils.Mensaje;

@Named
@ViewScoped
public class ViewCalificacionPendienteController extends AbstractViewController<ViewCalificacionPendiente>{
    @PostConstruct
    public void init() {
        ViewCalificacionPendienteService sv = (ViewCalificacionPendienteService) super.servicio;
        super.listado = sv.getAllByDocente(super.vUsuario.getRegistro().getDocente());
    }

    public void insertCalificacion() {
        ViewCalificacionPendienteService sv = (ViewCalificacionPendienteService) super.servicio;
        Mensaje mensaje = sv.insertCalificacion(super.registro);
        super.registro = null;

        if (mensaje != null) {
            if (mensaje.isRealizado()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion confirmada con exito!!!", "");
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
