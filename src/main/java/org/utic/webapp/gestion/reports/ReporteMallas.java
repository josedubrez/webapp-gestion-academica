package org.utic.webapp.gestion.reports;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.ViewReporteMallas;
import org.utic.webapp.gestion.repositories.MallaRepository;
import org.utic.webapp.gestion.repositories.ViewReporteMallasRepository;
import org.utic.webapp.gestion.services.PlanCursoService;
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
        List<ViewReporteMallas> listado = repo.getAll();
        Jasper.generateReport(listado, "reports/rep_mallas.jasper");
    }

    public ReportFilter getFiltro() { return filtro; }

    public List<Malla> getComboMallas() {return comboMallas;}
}
