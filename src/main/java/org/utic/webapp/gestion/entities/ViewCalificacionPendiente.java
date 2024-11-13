package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "v_calificaciones_pendientes")
public class ViewCalificacionPendiente extends AbstractEntity<ViewCalificacionPendiente>{
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan_curso")
    private PlanCurso planCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    @Column(name = "puntaje_trabajos_clases")
    private Integer puntajeTrabajosClases;

    @Column(name = "puntaje_trabajo_practico")
    private Integer puntajeTrabajoPractico;

    @Column(name = "puntaje_examen_parcial")
    private Integer puntajeExamenParcial;

    @Column(name = "puntaje_examen_final")
    private Integer puntajeExamenFinal;

    private Integer calificacion;
    private Boolean felicitado;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public PlanCurso getPlanCurso() {
        return planCurso;
    }

    public void setPlanCurso(PlanCurso planCurso) {
        this.planCurso = planCurso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getPuntajeTrabajosClases() {
        return puntajeTrabajosClases;
    }

    public void setPuntajeTrabajosClases(Integer puntajeTrabajosClases) {
        this.puntajeTrabajosClases = puntajeTrabajosClases;
    }

    public Integer getPuntajeTrabajoPractico() {
        return puntajeTrabajoPractico;
    }

    public void setPuntajeTrabajoPractico(Integer puntajeTrabajoPractico) {
        this.puntajeTrabajoPractico = puntajeTrabajoPractico;
    }

    public Integer getPuntajeExamenParcial() {
        return puntajeExamenParcial;
    }

    public void setPuntajeExamenParcial(Integer puntajeExamenParcial) {
        this.puntajeExamenParcial = puntajeExamenParcial;
    }

    public Integer getPuntajeExamenFinal() {
        return puntajeExamenFinal;
    }

    public void setPuntajeExamenFinal(Integer puntajeExamenFinal) {
        this.puntajeExamenFinal = puntajeExamenFinal;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Boolean getFelicitado() {
        return felicitado;
    }

    public void setFelicitado(Boolean felicitado) {
        this.felicitado = felicitado;
    }
}
