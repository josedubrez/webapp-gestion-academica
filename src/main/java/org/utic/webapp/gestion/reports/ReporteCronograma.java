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
public class ReporteCronograma implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ReportFilter filtro;
    @Inject
    private ViewReporteCronogramaRepository repo;

    //Filtros
    @Inject
    private MallaRepository repoMalla;
    private List<Malla> comboMallas;

    @Inject
    private PlanCursoRepository repoPlanCurso;
    private List<PlanCurso> comboPlanesCursos;

    @Inject
    private DocenteRepository repoDocente;
    private List<Docente> comboDocentes;

    //

    @PostConstruct
    public void init() {
        this.comboMallas = repoMalla.getAll();
        this.comboPlanesCursos = repoPlanCurso.getAll();
        this.comboDocentes = repoDocente.getAll();
    }

    public void generar(){
        if (filtro.getMalla() == null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar filtro de Malla!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
            return;
        }
        if (filtro.getNroSemestre() == null){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar filtro de Nro Semestre!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
            return;
        }

        List<ViewReporteCronograma> listado = repo.getAllByCustom(filtro.getMalla(),
                                                                    filtro.getNroSemestre(),
                                                                    filtro.getPlanCurso(),
                                                                    filtro.getDocente());

        if (!listado.isEmpty()){
            Jasper.generateReport(listado, "reports/rep_cronograma.jasper");
            for (ViewReporteCronograma e : listado){ System.out.println(e); }
        }else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se recuperaron registros para los filtros utilizados!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
        }
    }

    public ReportFilter getFiltro() { return filtro; }

    public List<Malla> getComboMallas() {
        return comboMallas;
    }

    public List<PlanCurso> getComboPlanesCursos() {
        return comboPlanesCursos;
    }

    public List<Docente> getComboDocentes() {
        return comboDocentes;
    }
}
