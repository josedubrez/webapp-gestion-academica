package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "justificativos_docentes")
public class JustificativoDocente extends AbstractEntity<JustificativoDocente>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @NotEmpty
    private String motivo;

    private LocalDate fecha;


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

}
