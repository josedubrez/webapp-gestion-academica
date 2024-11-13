package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reemplazos")
public class ReemplazoDocente extends AbstractEntity<ReemplazoDocente>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    @NotNull
    private Docente docente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan_curso")
    @NotNull
    private PlanCurso planCurso;

    private LocalDateTime fecha_ini;
    private LocalDateTime fecha_fin;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull PlanCurso getPlanCurso() {
        return planCurso;
    }

    public void setPlanCurso(@NotNull PlanCurso planCurso) {
        this.planCurso = planCurso;
    }


    public LocalDateTime getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(LocalDateTime fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


    public @NotNull Docente getDocente() {
        return docente;
    }

    public void setDocente(@NotNull Docente docente) {
        this.docente = docente;
    }
}
