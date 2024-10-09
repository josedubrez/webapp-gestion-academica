package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "requisitos_docentes_det")
public class RequisitoDocenteDet extends AbstractEntity<RequisitoDocenteDet>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_postulante")
    private Postulante postulante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_requisito_docente")
    private RequisitoDocente requisitoDocente;

    @Column(name = "dir_archivo")
    private String dirArchivo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public RequisitoDocente getRequisitoDocente() {
        return requisitoDocente;
    }

    public void setRequisitoDocente(RequisitoDocente requisitoDocente) {
        this.requisitoDocente = requisitoDocente;
    }

    public String getDirArchivo() {
        return dirArchivo;
    }

    public void setDirArchivo(String dirArchivo) {
        this.dirArchivo = dirArchivo;
    }
}
