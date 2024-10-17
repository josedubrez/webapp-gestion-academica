package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.AsistenciaAlumno;
import org.utic.webapp.gestion.services.AsistenciaAlumnoService;

@Named
@ViewScoped
public class AsistenciaAlumnoController extends AbstractCrudController<AsistenciaAlumno>{
    @Override
    protected AsistenciaAlumno createNewInstance() {
        return new AsistenciaAlumno();
    }

    @PostConstruct
    public void init() {
        AsistenciaAlumnoService aas = (AsistenciaAlumnoService) super.servicio;
        super.listado = aas.getAllByClase(filtrador.getFiltroClase());
    }
}
