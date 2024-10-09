package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table (name="mallas")
public class Malla extends AbstractEntity<Malla>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_carrera")
    private Carrera carrera;

    @NotNull
    @Positive
    @Column(name = "cantidad_semestres")
    private Integer cantidadSemestres;

    @NotNull
    @Positive
    private Integer anio;

    @NotNull
    @Positive
    private Integer cupos;

    private Boolean aprobado;

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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Integer getCantidadSemestres() {
        return cantidadSemestres;
    }

    public void setCantidadSemestres(Integer cantidadSemestres) {
        this.cantidadSemestres = cantidadSemestres;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }
}
