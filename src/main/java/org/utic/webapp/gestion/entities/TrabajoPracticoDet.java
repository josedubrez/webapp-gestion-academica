package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajos_practicos_det")
public class TrabajoPracticoDet extends AbstractEntity<TrabajoPracticoDet>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_trabajo_practico")
    private TrabajoPractico trabajoPractico;

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

    public TrabajoPractico getTrabajoPractico() {
        return trabajoPractico;
    }

    public void setTrabajoPractico(TrabajoPractico trabajoPractico) {
        this.trabajoPractico = trabajoPractico;
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
