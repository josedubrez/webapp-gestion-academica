package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.TrabajoClase;
import org.utic.webapp.gestion.services.TrabajoClaseService;

@Named
@ViewScoped
public class TrabajoClaseController extends AbstractCrudController<TrabajoClase>{
    @Override
    protected TrabajoClase createNewInstance() {
        return new TrabajoClase();
    }

    @PostConstruct
    public void init() {
        TrabajoClaseService tcs = (TrabajoClaseService) super.servicio;
        super.listado = tcs.getAllByClase(filtrador.getFiltroClase());
        super.resetSeleccionado();
    }

    public void resetSeleccionado() {
        super.resetSeleccionado();
        super.seleccionado.setClase(filtrador.getFiltroClase());
    }

    public String volverAClase() {
        return "clases?faces-redirect=true";
    }

    public String volverAMisClases() {
        return "mis_clases?faces-redirect=true";
    }

    public String irAMisTrabajosClasesDet() {
        return "mis_trabajos_clases_det?faces-redirect=true";
    }
}
