package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "v_reporte_justificativos")
public class ViewReporteJustificativos extends AbstractEntity<ViewReporteJustificativos>{
    @Id
    private Long id;

    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @Column(name = "desc_fecha")
    private String descFecha;

    @Column(name = "desc_docente")
    private String descDocente;

    @Column(name = "desc_motivo")
    private String descMotivo;

    @Column(name = "dir_archivo")
    private String dirArchivo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDescDocente() {
        return descDocente;
    }

    public void setDescDocente(String descDocente) {
        this.descDocente = descDocente;
    }

    public String getDescMotivo() {
        return descMotivo;
    }

    public void setDescMotivo(String descMotivo) {
        this.descMotivo = descMotivo;
    }

    public String getDirArchivo() {
        return dirArchivo;
    }

    public void setDirArchivo(String dirArchivo) {
        this.dirArchivo = dirArchivo;
    }

    public String getDescFecha() {
        return descFecha;
    }

    public void setDescFecha(String descFecha) {
        this.descFecha = descFecha;
    }
}