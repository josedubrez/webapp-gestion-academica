package org.utic.webapp.gestion.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Materia;
import org.utic.webapp.gestion.entities.Referencial;
import org.utic.webapp.gestion.entities.Temario;
import org.utic.webapp.gestion.services.ReferencialService;
import org.utic.webapp.gestion.services.TemarioService;

import java.util.List;

@Named
@ViewScoped
public class ReferencialController extends AbstractCrudController<Referencial>{

    private List<Referencial> comboReferencial;
    private List<Materia> comboMaterias;

    @Override
    protected Referencial createNewInstance() {
        return new Referencial();
    }

    @PostConstruct
    public void init() {
        ReferencialService mds = (ReferencialService) super.servicio;
        this.listado = mds.getReferencialAllByMallaDet(filtrador.getFiltroMallaDet());
        super.resetSeleccionado();
        this.comboReferencial = this.listado;
        this.comboMaterias =  mds.getMateriasAll();
        //System.out.println("TEMARIO_CONTROLLER.INIT: " + this + " " + filtrador.getFiltroMallaDet());
    }

    @Override
    public void resetSeleccionado() {
        super.resetSeleccionado();
        this.seleccionado.setMallaDet(filtrador.getFiltroMallaDet());
    }

    public String irAMallaDet() {
        return "mallas_det?faces-redirect=true";
    }

    public List<Referencial> getComboReferencial() {
        return comboReferencial;
    }

    public void setComboReferencial(List<Referencial> comboReferencial) {
        this.comboReferencial = comboReferencial;
    }

    public List<Materia> getComboMaterias() {
        return comboMaterias;
    }

    public void setComboMaterias(List<Materia> comboMaterias) {
        this.comboMaterias = comboMaterias;
    }
}
