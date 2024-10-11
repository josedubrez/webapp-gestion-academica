package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Rol;
import org.utic.webapp.gestion.entities.RolUsuario;
import org.utic.webapp.gestion.services.RolUsuarioService;

import java.util.List;

@Named
@ViewScoped
public class RolUsuarioController extends AbstractCrudController<RolUsuario>{

    private List<Rol> comboRoles;

    @PostConstruct
    public void init() {
        RolUsuarioService rus = (RolUsuarioService) super.servicio;
        this.listado = rus.getAllByUsuario(filtrador.getFiltroUsuario());
        super.resetSeleccionado();
        this.comboRoles = rus.getRolesAll();
    }

    @Override
    protected RolUsuario createNewInstance() {
        return new RolUsuario();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setUsuario(filtrador.getFiltroUsuario());
    }

    public List<Rol> getComboRoles() {
        return comboRoles;
    }

    public String volverAUsuario() {
        return "usuarios?faces-redirect=true";
    }
}
