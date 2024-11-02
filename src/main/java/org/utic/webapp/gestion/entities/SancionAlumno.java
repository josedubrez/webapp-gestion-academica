package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

@Entity
@Table(name = "sanciones_alumnos")
public class SancionAlumno extends AbstractEntity<SancionAlumno>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla")
    private Malla malla;

    @NotEmpty
    private String motivo;

    private LocalDate fecha;

    /*@Column(name = "fecha_alta")
    private LocalDate fechaAlta;*/

    @Column(name = "dir_archivo")
    private String dirArchivo;



    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDirArchivo() {
        return dirArchivo;
    }

    public void setDirArchivo(String dirArchivo) {
        this.dirArchivo = dirArchivo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }


    public Malla getMalla() {
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }
}
