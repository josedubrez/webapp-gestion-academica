package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name="mallas_det")
public class MallaDet extends AbstractEntity<MallaDet>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla")
    private Malla malla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_materia")
    private Materia materia;

    @NotNull
    @Positive
    @Column(name = "nro_semestre")
    private Integer nroSemestre;

    @NotNull
    @Positive
    @Column(name = "horas_catedra")
    private Integer horasCatedra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla_det_ref")
    private MallaDet mallaDetRef;

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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getNroSemestre() {
        return nroSemestre;
    }

    public void setNroSemestre(Integer nroSemestre) {
        this.nroSemestre = nroSemestre;
    }

    public Integer getHorasCatedra() {
        return horasCatedra;
    }

    public void setHorasCatedra(Integer horasCatedra) {
        this.horasCatedra = horasCatedra;
    }

    public MallaDet getMallaDetRef() {
        return mallaDetRef;
    }

    public void setMallaDetRef(MallaDet mallaDet) {
        this.mallaDetRef = mallaDet;
    }
}
