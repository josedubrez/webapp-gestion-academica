package org.utic.webapp.gestion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "v_reporte_mallas")
public class ViewReporteMallas extends AbstractEntity<ViewReporteMallas>{
    @Id
    private Long id;

    @Column(name = "desc_malla")
    private String descMalla;

    @Column(name = "nro_semestre")
    private String nroSemestre;

    @Column(name = "horas_catedra")
    private String horasCatedra;

    private String sigla;

    @Column(name = "desc_materia")
    private String descMateria;

    @Column(name = "desc_materia_correlativa")
    private String descMateriaCorrelativa;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescMalla() {
        return descMalla;
    }

    public void setDescMalla(String descMalla) {
        this.descMalla = descMalla;
    }

    public String getNroSemestre() {
        return nroSemestre;
    }

    public void setNroSemestre(String nroSemestre) {
        this.nroSemestre = nroSemestre;
    }

    public String getHorasCatedra() {
        return horasCatedra;
    }

    public void setHorasCatedra(String horasCatedra) {
        this.horasCatedra = horasCatedra;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescMateria() {
        return descMateria;
    }

    public void setDescMateria(String descMateria) {
        this.descMateria = descMateria;
    }

    public String getDescMateriaCorrelativa() {
        return descMateriaCorrelativa;
    }

    public void setDescMateriaCorrelativa(String descMateriaCorrelativa) {
        this.descMateriaCorrelativa = descMateriaCorrelativa;
    }

    @Override
    public String toString() {
        return descMalla + ", " + nroSemestre + ", " + sigla + ", " + descMateria;
    }
}