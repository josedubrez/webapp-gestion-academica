package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "temarios")
public class Temario extends AbstractEntity<Temario> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String descripcion;

    @NotNull
    @Positive
    private Integer unidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla_det")
    private MallaDet mallaDet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_temario_padre")
    private Temario temarioPadre;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public MallaDet getMallaDet() {
        return mallaDet;
    }

    public void setMallaDet(MallaDet mallaDet) {
        this.mallaDet = mallaDet;
    }

    public Temario getTemarioPadre() {
        return temarioPadre;
    }

    public void setTemarioPadre(Temario temarioPadre) {
        this.temarioPadre = temarioPadre;
    }
}
