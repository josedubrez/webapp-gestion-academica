package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "examenes")
public class Examen extends AbstractEntity<Examen>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan_curso")
    private PlanCurso planCurso;

    private LocalDate fecha;

    @NotEmpty
    @Column(name = "tipo_examen")
    private String tipoExamen;

    @NotEmpty
    @Column(name = "forma_examen")
    private String formaExamen;

    @NotNull
    @Positive
    private Integer puntaje;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getFormaExamen() {
        return formaExamen;
    }

    public void setFormaExamen(String formaExamen) {
        this.formaExamen = formaExamen;
    }

    public String getTipoExamenDesc() {
        if (tipoExamen != null) {
            return tipoExamen.equals("P") ?
                    "Parcial" :
                    "Final";

        }
        return null;
    }

    public String getFormaExamenDesc() {
        if (formaExamen != null) {
            return formaExamen.equals("PO") ?
                    "Primera Oportunidad" :
                    formaExamen.equals("SO") ?
                            "Segunda Oportunidad" :
                            "Extraordinario";
        }
        return null;
    }

}
