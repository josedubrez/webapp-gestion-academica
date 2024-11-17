package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "v_reporte_asistencias")
public class ViewReporteAsistencias extends AbstractEntity<ViewReporteAsistencias>{
    @Id
    private Long id;

    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan_curso")
    private PlanCurso planCurso;

    @Column(name = "desc_fecha")
    private String descFecha;

    @Column(name = "desc_materia")
    private String descMateria;

    @Column(name = "desc_alumno")
    private String descAlumno;

    @Column(name = "desc_docente")
    private String descDocente;

    @Column(name = "desc_presente")
    private String descPresente;

    @Column(name = "desc_justificativo")
    private String descJustificativo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public PlanCurso getPlanCurso() {
        return planCurso;
    }

    public void setPlanCurso(PlanCurso planCurso) {
        this.planCurso = planCurso;
    }

    public String getDescFecha() {
        return descFecha;
    }

    public void setDescFecha(String descFecha) {
        this.descFecha = descFecha;
    }

    public String getDescMateria() {
        return descMateria;
    }

    public void setDescMateria(String descMateria) {
        this.descMateria = descMateria;
    }

    public String getDescAlumno() {
        return descAlumno;
    }

    public void setDescAlumno(String descAlumno) {
        this.descAlumno = descAlumno;
    }

    public String getDescPresente() {
        return descPresente;
    }

    public void setDescPresente(String descPresente) {
        this.descPresente = descPresente;
    }

    public String getDescJustificativo() {
        return descJustificativo;
    }

    public void setDescJustificativo(String descJustificativo) {
        this.descJustificativo = descJustificativo;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDescDocente() {
        return descDocente;
    }

    public void setDescDocente(String descDocente) {
        this.descDocente = descDocente;
    }

    @Override
    public String toString() {
        return getDescFecha() + ", " + getDescMateria() + ", " + getDescAlumno() + ", " + getDescDocente() + ", " + getDescPresente();
    }
}