package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.ViewPermisoUsuario;
import org.utic.webapp.gestion.services.ViewPermisoUsuarioService;

@Named
@SessionScoped
public class ViewPermisoUsuarioController extends AbstractViewController<ViewPermisoUsuario>{
    private ViewPermisoUsuario nuevo;

    @PostConstruct
    public void init() {
        //super.registro = super.servicio.getAll().get(0);
        super.registro = new ViewPermisoUsuario();
        this.nuevo = new ViewPermisoUsuario();
    }

    public String login(){
        ViewPermisoUsuarioService vus = (ViewPermisoUsuarioService) this.servicio;
        super.registro = vus.getByUsernameAndPassword(this.nuevo.getUsername(), this.nuevo.getPassword());
        this.nuevo.setUsername("");
        this.nuevo.setPassword("");
        PrimeFaces.current().ajax().update("form:manage-content");

        return (super.registro != null) ? "welcome?faces-redirect=true" : null;
    }

    public void setRegistro(ViewPermisoUsuario registro) {
        super.registro = registro;
    }

    public ViewPermisoUsuario getRegistro() {
        return registro;
    }

    public void setNuevo(ViewPermisoUsuario nuevo) {
        this.nuevo = nuevo;
    }

    public ViewPermisoUsuario getNuevo() {
        return nuevo;
    }
}