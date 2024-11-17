package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "v_reporte_contrato")
public class ViewReporteContrato extends AbstractEntity<ViewReporteContrato>{
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @Column(name = "desc_contrato")
    private String descContrato;

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

    public String getDescContrato() {
        return descContrato;
    }

    public void setDescContrato(String descContrato) {
        this.descContrato = descContrato;
    }
}