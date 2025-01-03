package org.utic.webapp.gestion.reports;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.ViewReporteMallas;
import org.utic.webapp.gestion.repositories.MallaRepository;
import org.utic.webapp.gestion.repositories.ViewReporteMallasRepository;
import org.utic.webapp.gestion.utils.Jasper;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ReporteMallas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ReportFilter filtro;
    @Inject
    private ViewReporteMallasRepository repo;

    //Filtros
    @Inject
    private MallaRepository repoMalla;
    private List<Malla> comboMallas;
    //

    @PostConstruct
    public void init() {
        this.comboMallas = repoMalla.getAll();
    }

    public void generar(){
        if (filtro.getMalla() == null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar filtro de malla!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
            return;
        }

        List<ViewReporteMallas> listado = repo.getAllByCustom(filtro.getMalla());

        if (!listado.isEmpty()){
            Jasper.generateReport(listado, "reports/rep_mallas.jasper");
        }else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se recuperaron registros para los filtros utilizados!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
        }
    }

    public ReportFilter getFiltro() { return filtro; }

    public List<Malla> getComboMallas() {return comboMallas;}
}
