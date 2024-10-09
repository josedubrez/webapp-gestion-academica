package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.EntityWithId;
import org.utic.webapp.gestion.services.CrudService;
import org.utic.webapp.gestion.utils.Mensaje;

import java.io.Serializable;
import java.util.List;


public abstract class AbstractCrudController<T extends EntityWithId> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected List<T> listado;
    protected T seleccionado;

    @Inject
    protected CrudService<T> servicio;

    @Inject
    FiltroController filtrador;

    @PostConstruct
    public void init() {
        try {
            this.listado = this.servicio.getAll();
            resetSeleccionado();
        } catch (Exception e) {
            e.printStackTrace();  // Imprimir el stack trace para mayor visibilidad
        }
    }

    public List<T> getListado() {
        return listado;
    }

    public T getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(T seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void resetSeleccionado() {
        this.seleccionado = createNewInstance();
    }

    protected abstract T createNewInstance();

    public void save() {
        System.out.println("ABSTRACT_CRUD_CONTROLLER.SAVE: " + this);
        boolean isNuevoRegistro = (this.seleccionado.getId() == null);
        Mensaje mensaje = this.servicio.save(this.seleccionado);

        if (mensaje != null) {
            if (mensaje.isRealizado()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        isNuevoRegistro ? "Registro insertado con exito!!!" : "Registro editado con exito!!!", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }else{
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje.getTitulo(), mensaje.getDetalle());
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }

        PrimeFaces.current().executeScript("PF('manageDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");

        this.init();
    }

    public void delete() {
        Mensaje mensaje = this.servicio.delete(this.seleccionado);
        this.seleccionado = null;

        if (mensaje != null) {
            if (mensaje.isRealizado()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro eliminado con exito!!!", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje.getTitulo(), mensaje.getDetalle()));
            }
        }

        PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");

        this.init();
    }
}