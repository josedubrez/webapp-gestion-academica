package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "planes_cursos")
public class PlanCurso extends AbstractEntity<PlanCurso>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla_det")
    private MallaDet mallaDet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_sede")
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_turno")
    private Turno turno;

    @Column(name = "fecha_exa_parcial")
    private LocalDate fechaExaParcial;

    @Column(name = "fecha_exa_final")
    private LocalDate fechaExaFinal;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    private Boolean aprobado;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public LocalDate getFechaExaParcial() {
        return fechaExaParcial;
    }

    public void setFechaExaParcial(LocalDate fechaExaParcial) {
        this.fechaExaParcial = fechaExaParcial;
    }

    public LocalDate getFechaExaFinal() {
        return fechaExaFinal;
    }

    public void setFechaExaFinal(LocalDate fechaExaFinal) {
        this.fechaExaFinal = fechaExaFinal;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public MallaDet getMallaDet() {
        return mallaDet;
    }

    public void setMallaDet(MallaDet mallaDet) {
        this.mallaDet = mallaDet;
    }
}
