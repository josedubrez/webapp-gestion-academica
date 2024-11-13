package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajos_clases_det")
public class TrabajoClaseDet extends AbstractEntity<TrabajoClase>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_trabajo_clase")
    private TrabajoClase trabajoClase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    private Integer puntaje;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrabajoClase getTrabajoClase() {
        return trabajoClase;
    }

    public void setTrabajoClase(TrabajoClase trabajoClase) {
        this.trabajoClase = trabajoClase;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
}
