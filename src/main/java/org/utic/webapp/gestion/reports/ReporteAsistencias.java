package org.utic.webapp.gestion.reports;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.repositories.AlumnoRepository;
import org.utic.webapp.gestion.repositories.DocenteRepository;
import org.utic.webapp.gestion.repositories.PlanCursoRepository;
import org.utic.webapp.gestion.repositories.ViewReporteAsistenciasRepository;
import org.utic.webapp.gestion.utils.Jasper;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ReporteAsistencias implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ReportFilter filtro;
    @Inject
    private ViewReporteAsistenciasRepository repo;

    //Filtros
    @Inject
    private AlumnoRepository repoAlumno;
    private List<Alumno> comboAlumnos;

    @Inject
    private DocenteRepository repoDocente;
    private List<Docente> comboDocentes;

    @Inject
    private PlanCursoRepository repoPlanCurso;
    private List<PlanCurso> comboPlanesCursos;
    //

    @PostConstruct
    public void init() {
        this.comboPlanesCursos = repoPlanCurso.getAll();
        this.comboAlumnos = repoAlumno.getAll();
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

        List<ViewReporteAsistencias> listado = repo.getAllByCustom(filtro.getFechaDesde(),
                                                                    filtro.getFechaHasta(),
                                                                    filtro.getAlumno(),
                                                                    filtro.getDocente(),
                                                                    filtro.getPlanCurso());

        if (!listado.isEmpty()){
            Jasper.generateReport(listado, "reports/rep_asistencias.jasper");
        }else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "No se recuperaron registros para los filtros utilizados!!!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            PrimeFaces.current().ajax().update("form:messages", "form:dt-listado");
        }

        //for (ViewReporteAsistencias e : listado){ System.out.println(e); }
    }

    public ReportFilter getFiltro() { return filtro; }

    public List<PlanCurso> getComboPlanesCursos() {return comboPlanesCursos;}
    public List<Alumno> getComboAlumnos() {return comboAlumnos;}
    public List<Docente> getComboDocentes() {return comboDocentes;}
}
