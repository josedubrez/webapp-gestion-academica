package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "distribuciones_escalas")
public class DistribucionEscala extends AbstractEntity<DistribucionEscala>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan_curso")
    private PlanCurso planCurso;

    @NotNull
    @Positive
    @Column(name = "puntaje_trabajos_clases")
    private Integer puntajeTrabajosClases;

    @NotNull
    @Positive
    @Column(name = "puntaje_trabajo_practico")
    private Integer puntajeTrabajosPracticos;

    @NotNull
    @Positive
    @Column(name = "puntaje_examen_parcial")
    private Integer puntajeExamenParcial;

    @NotNull
    @Positive
    @Column(name = "puntaje_examen_final")
    private Integer puntajeExamenFinal;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanCurso getPlanCurso() {
        return planCurso;
    }

    public void setPlanCurso(PlanCurso planCurso) {
        this.planCurso = planCurso;
    }

    public Integer getPuntajeTrabajosClases() {
        return puntajeTrabajosClases;
    }

    public void setPuntajeTrabajosClases(Integer puntajeTrabajosClases) {
        this.puntajeTrabajosClases = puntajeTrabajosClases;
    }

    public Integer getPuntajeTrabajosPracticos() {
        return puntajeTrabajosPracticos;
    }

    public void setPuntajeTrabajosPracticos(Integer puntajeTrabajosPracticos) {
        this.puntajeTrabajosPracticos = puntajeTrabajosPracticos;
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
}
