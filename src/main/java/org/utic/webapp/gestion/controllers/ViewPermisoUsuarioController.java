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

    @PostConstruct
    public void init() {
        super.init();
        this.nuevo = new ViewPermisoUsuario();
    }

    public String login(){
        ViewPermisoUsuarioService vus = (ViewPermisoUsuarioService) this.servicio;
        this.registro = vus.getByUsernameAndPassword(this.nuevo.getUsername(), this.nuevo.getPassword());
        this.nuevo.setUsername("");
        this.nuevo.setPassword("");
        PrimeFaces.current().ajax().update("form:manage-content");

        return (this.registro != null) ? "welcome?faces-redirect=true" : null;
    }
}
