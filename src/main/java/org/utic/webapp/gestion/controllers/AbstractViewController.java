package org.utic.webapp.gestion.controllers;

import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.EntityWithId;
import org.utic.webapp.gestion.services.ViewService;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractViewController<T extends EntityWithId> implements Serializable {
    private static final long serialVersionUID = 1L;

    protected List<T> listado;
    protected T registro;

    @Inject
    protected ViewService<T> servicio;

    @Inject
    protected ViewPermisoUsuarioController vUsuario;

    public List<T> getListado() {
        return listado;
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
    }
}
