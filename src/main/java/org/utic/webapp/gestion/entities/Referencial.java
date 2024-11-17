package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "referenciales")
public class Referencial extends AbstractEntity<Referencial> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla_det")
    private MallaDet mallaDet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_materia")
    private Materia materia;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public MallaDet getMallaDet() {
        return mallaDet;
    }

    public void setMallaDet(MallaDet mallaDet) {
        this.mallaDet = mallaDet;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
}
