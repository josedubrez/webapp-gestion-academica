package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.EntityWithId;
import org.utic.webapp.gestion.entities.ViewPermisoUsuario;
import org.utic.webapp.gestion.services.ViewService;

import java.io.Serializable;

public abstract class AbstractViewController<T extends EntityWithId> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected T registro;
    protected T nuevo;

    @Inject
    protected ViewService<T> servicio;

    @PostConstruct
    public void init() {
        this.registro = this.servicio.getAll().get(0);
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }

    public T getRegistro() {
        return registro;
    }

    public void setNuevo(T nuevo) {
        this.nuevo = nuevo;
    }

    public T getNuevo() {
        return nuevo;
    }
}
