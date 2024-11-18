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
public class ReporteCalificaciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private ReportFilter filtro;
    @Inject
    private ViewReporteCalificacionesRepository repo;

    //Filtros
    @Inject
    private MallaRepository repoMalla;
    private List<Malla> comboMallas;

    @Inject
    private MallaDetRepository repoMallaDet;
    private List<MallaDet> comboMallasDet;

    @Inject
    private SedeRepository repoSede;
    private List<Sede> comboSedes;

    @Inject
    private TurnoRepository repoTurno;
    private List<Turno> comboTurnos;

    @Inject
    private DocenteRepository repoDocente;
    private List<Docente> comboDocentes;

    @Inject
    private AlumnoRepository repoAlumno;
    private List<Alumno> comboAlumnos;

    //

    @PostConstruct
    public void init() {
        this.comboMallas = repoMalla.getAll();
        this.comboMallasDet = repoMallaDet.getAll();
        this.comboSedes = repoSede.getAll();
        this.comboTurnos = repoTurno.getAll();
        this.comboDocentes = repoDocente.getAll();
        this.comboAlumnos = repoAlumno.getAll();
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

        List<ViewReporteCalificaciones> listado = repo.getAllByCustom(filtro.getMalla(),
                                                                    filtro.getNroSemestre(),
                                                                    filtro.getMallaDet(),
                                                                    filtro.getSede(),
                                                                    filtro.getTurno(),
                                                                    filtro.getDocente(),
                                                                    filtro.getAlumno());

        if (!listado.isEmpty()){
            Jasper.generateReport(listado, "reports/rep_calificaciones.jasper");
            for (ViewReporteCalificaciones e : listado){ System.out.println(e); }
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

    public List<Docente> getComboDocentes() {
        return comboDocentes;
    }

    public List<Alumno> getComboAlumnos() {
        return comboAlumnos;
    }

    public List<Turno> getComboTurnos() {
        return comboTurnos;
    }

    public List<Sede> getComboSedes() {
        return comboSedes;
    }

    public List<MallaDet> getComboMallasDet() {
        return comboMallasDet;
    }
}
