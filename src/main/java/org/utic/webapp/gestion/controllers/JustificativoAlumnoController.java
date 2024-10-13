package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Alumno;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.JustificativoAlumno;
import org.utic.webapp.gestion.entities.PermisoDocente;
import org.utic.webapp.gestion.services.JustificativoAlumnoService;
import org.utic.webapp.gestion.services.PermisoDocenteService;

import java.util.List;

@Named
@ViewScoped
public class JustificativoAlumnoController extends AbstractCrudController<JustificativoAlumno>{

    private List<Alumno> comboAlumnos;

    @PostConstruct
    public void init() {
        super.init();
        JustificativoAlumnoService pds = (JustificativoAlumnoService) super.servicio;
        this.comboAlumnos =  pds.getAlumnoAll();
    }

    @Override
    protected JustificativoAlumno createNewInstance() {
        return new JustificativoAlumno();
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }
}
