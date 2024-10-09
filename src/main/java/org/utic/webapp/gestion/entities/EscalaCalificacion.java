package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "escalas_calificaciones")
public class EscalaCalificacion extends AbstractEntity<EscalaCalificacion>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla")
    private Malla malla;

    @NotNull
    @Positive
    private Integer puntaje2;

    @NotNull
    @Positive
    private Integer puntaje3;

    @NotNull
    @Positive
    private Integer puntaje4;

    @NotNull
    @Positive
    private Integer puntaje5;

    @NotNull
    @Positive
    private Integer puntaje5f;

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

    public Integer getPuntaje2() {
        return puntaje2;
    }

    public void setPuntaje2(Integer puntaje2) {
        this.puntaje2 = puntaje2;
    }

    public Integer getPuntaje3() {
        return puntaje3;
    }

    public void setPuntaje3(Integer puntaje3) {
        this.puntaje3 = puntaje3;
    }

    public Integer getPuntaje4() {
        return puntaje4;
    }

    public void setPuntaje4(Integer puntaje4) {
        this.puntaje4 = puntaje4;
    }

    public Integer getPuntaje5() {
        return puntaje5;
    }

    public void setPuntaje5(Integer puntaje5) {
        this.puntaje5 = puntaje5;
    }

    public Integer getPuntaje5f() {
        return puntaje5f;
    }

    public void setPuntaje5f(Integer puntaje5f) {
        this.puntaje5f = puntaje5f;
    }
}
