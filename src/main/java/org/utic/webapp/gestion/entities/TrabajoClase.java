package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "trabajos_clases")
public class TrabajoClase extends AbstractEntity<TrabajoClase>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_clase")
    private Clase clase;

    @NotEmpty
    private String titulo;

    @NotNull
    @Positive
    private Integer puntaje;

    @Column(name = "es_acumulativo")
    private Boolean esAcumulativo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Boolean getEsAcumulativo() {
        return esAcumulativo;
    }

    public void setEsAcumulativo(Boolean esAcumulativo) {
        this.esAcumulativo = esAcumulativo;
    }
}
