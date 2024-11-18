package org.utic.webapp.gestion.reports;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.*;
import org.utic.webapp.gestion.utils.Jasper;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ReporteJustificativos implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ReportFilter filtro;
    @Inject
    private ViewReporteJustificativosRepository repo;

    //Filtros
    @Inject
    private DocenteRepository repoDocente;
    private List<Docente> comboDocentes;
    //

    @PostConstruct
    public void init() {
        this.comboDocentes = repoDocente.getAll();
    }

    public void generar(){
        if (filtro.getFechaDesde() == null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar filtro de fecha desde!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
            return;
        }
        if (filtro.getFechaHasta() == null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar filtro de fecha hasta!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
            return;
        }

        List<ViewReporteJustificativos> listado = repo.getAllByCustom(filtro.getFechaDesde(),
                                                                    filtro.getFechaHasta(),
                                                                    filtro.getDocente());

        if (!listado.isEmpty()){
            Jasper.generateReport(listado, "reports/rep_justificativos.jasper");
            for (ViewReporteJustificativos e : listado){ System.out.println(e); }
        }else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se recuperaron registros para los filtros utilizados!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
        }
    }

    public ReportFilter getFiltro() { return filtro; }

    public List<Docente> getComboDocentes() {return comboDocentes;}
}
