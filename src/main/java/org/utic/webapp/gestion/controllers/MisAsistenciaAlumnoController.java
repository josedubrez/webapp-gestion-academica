package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.AsistenciaAlumno;
import org.utic.webapp.gestion.services.AsistenciaAlumnoService;
import org.utic.webapp.gestion.utils.Mensaje;

@Named
@ViewScoped
public class MisAsistenciaAlumnoController extends AbstractCrudController<AsistenciaAlumno>{
    @Inject
    private ViewPermisoUsuarioController vUsuario;

    @Override
    protected AsistenciaAlumno createNewInstance() {
        return new AsistenciaAlumno();
    }

    @PostConstruct
    public void init() {
        AsistenciaAlumnoService aas = (AsistenciaAlumnoService) super.servicio;
        super.listado = aas.getAllByDocente(vUsuario.getRegistro().getDocente());
        if (super.listado != null && !super.listado.isEmpty()){
            this.seleccionado = super.listado.get(0);
        }
    }

    public void guardarCambios(){
        AsistenciaAlumnoService aas = (AsistenciaAlumnoService) super.servicio;
        Mensaje mensaje = new Mensaje(false, "", "");
        boolean procesado_ok = true;

        if (super.listado != null && !super.listado.isEmpty()){
            for (AsistenciaAlumno a: super.listado){
                mensaje = aas.save(a);
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

}
