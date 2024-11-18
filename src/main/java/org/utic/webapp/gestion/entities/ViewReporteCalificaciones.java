package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "v_reporte_calificaciones")
public class ViewReporteCalificaciones extends AbstractEntity<ViewReporteCalificaciones>{
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla")
    private Malla malla;

    @Column(name = "nro_semestre")
    private Integer nroSemestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla_det")
    private MallaDet mallaDet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sede")
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_turno")
    private Turno turno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    @Column(name = "desc_malla")
    private String descMalla;

    @Column(name = "desc_materia")
    private String descMateria;

    @Column(name = "desc_sede")
    private String descSede;

    @Column(name = "desc_turno")
    private String descTurno;

    @Column(name = "desc_docente")
    private String descDocente;

    @Column(name = "desc_alumno")
    private String descAlumno;

    @Column(name = "desc_calificacion")
    private String descCalificacion;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Malla getMalla() {
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public Integer getNroSemestre() {
        return nroSemestre;
    }

    public void setNroSemestre(Integer nroSemestre) {
        this.nroSemestre = nroSemestre;
    }

    public MallaDet getMallaDet() {
        return mallaDet;
    }

    public void setMallaDet(MallaDet mallaDet) {
        this.mallaDet = mallaDet;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getDescMalla() {
        return descMalla;
    }

    public void setDescMalla(String descMalla) {
        this.descMalla = descMalla;
    }

    public String getDescMateria() {
        return descMateria;
    }

    public void setDescMateria(String descMateria) {
        this.descMateria = descMateria;
    }

    public String getDescSede() {
        return descSede;
    }

    public void setDescSede(String descSede) {
        this.descSede = descSede;
    }

    public String getDescTurno() {
        return descTurno;
    }

    public void setDescTurno(String descTurno) {
        this.descTurno = descTurno;
    }

    public String getDescDocente() {
        return descDocente;
    }

    public void setDescDocente(String descDocente) {
        this.descDocente = descDocente;
    }

    public String getDescCalificacion() {
        return descCalificacion;
    }

    public void setDescCalificacion(String descCalificacion) {
        this.descCalificacion = descCalificacion;
    }

    public String getDescAlumno() {
        return descAlumno;
    }

    public void setDescAlumno(String descAlumno) {
        this.descAlumno = descAlumno;
    }
}