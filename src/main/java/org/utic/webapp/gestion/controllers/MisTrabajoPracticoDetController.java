package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.TrabajoPracticoDet;
import org.utic.webapp.gestion.services.TrabajoPracticoDetService;
import org.utic.webapp.gestion.utils.Mensaje;

@Named
@ViewScoped
public class MisTrabajoPracticoDetController extends AbstractCrudController<TrabajoPracticoDet>{
    @Override
    protected TrabajoPracticoDet createNewInstance() {
        return new TrabajoPracticoDet();
    }

    @PostConstruct
    public void init() {
        TrabajoPracticoDetService tpds = (TrabajoPracticoDetService) super.servicio;
        super.listado = tpds.getAllByTrabajoPractico(filtrador.getFiltroTrabajoPractico());
    }

    public void guardarCambios(){
        TrabajoPracticoDetService tpds = (TrabajoPracticoDetService) super.servicio;
        Mensaje mensaje = new Mensaje(false, "", "");
        boolean procesado_ok = true;

        if (super.listado != null && !super.listado.isEmpty()){
            for (TrabajoPracticoDet tpd: super.listado){
                mensaje = tpds.save(tpd);
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
        return "mis_trabajos_practicos?faces-redirect=true";
    }
}
