package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "permisos_docentes")
public class PermisoDocente extends AbstractEntity<PermisoDocente>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @NotEmpty
    private String motivo;

    @Column(name = "fecha_alta")
    private LocalDate fecha;

    private LocalDateTime fecha_ini;
    private LocalDateTime fecha_fin;

    @Column(name = "dir_archivo")
    private String dirArchivo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
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

    public LocalDateTime getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(LocalDateTime fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
