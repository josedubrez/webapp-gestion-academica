package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "v_reporte_cronograma")
public class ViewReporteCronograma extends AbstractEntity<ViewReporteCronograma>{
    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_malla")
    private Malla malla;

    @Column(name = "nro_semestre")
    private Integer nroSemestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan_curso")
    private PlanCurso planCurso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    @Column(name = "desc_malla")
    private String descMalla;

    @Column(name = "desc_plan_curso")
    private String descPlanCurso;

    @Column(name = "desc_materia")
    private String descMateria;

    @Column(name = "desc_docente")
    private String descDocente;

    @Column(name = "desc_sede")
    private String descSede;

    @Column(name = "desc_turno")
    private String descTurno;

    @Column(name = "desc_fecha_inicio")
    private String descFechaInicio;

    @Column(name = "desc_fecha_fin")
    private String descFechaFin;

    @Column(name = "desc_fecha_exa_parcial")
    private String descFechaExaParcial;

    @Column(name = "desc_fecha_exa_final")
    private String descFechaExaFinal;

    @Column(name = "desc_dia_semana")
    private String descDiaSemana;

    @Column(name = "desc_aula")
    private String descAula;

    @Column(name = "horario_desde")
    private String horarioDesde;

    @Column(name = "horario_hasta")
    private String horarioHasta;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Malla getMalla() {
        return malla;
    }

    public void setMalla(Malla malla) {
        this.malla = malla;
    }

    public Integer getNroSemestre() {
        return nroSemestre;
    }

    public void setNroSemestre(Integer nroSemestre) {
        this.nroSemestre = nroSemestre;
    }

    public PlanCurso getPlanCurso() {
        return planCurso;
    }

    public void setPlanCurso(PlanCurso planCurso) {
        this.planCurso = planCurso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDescMalla() {
        return descMalla;
    }

    public void setDescMalla(String descMalla) {
        this.descMalla = descMalla;
    }

    public String getDescMateria() {
        return descMateria;
    }

    public void setDescMateria(String descMateria) {
        this.descMateria = descMateria;
    }

    public String getDescDocente() {
        return descDocente;
    }

    public void setDescDocente(String descDocente) {
        this.descDocente = descDocente;
    }

    public String getDescFechaInicio() {
        return descFechaInicio;
    }

    public void setDescFechaInicio(String descFechaInicio) {
        this.descFechaInicio = descFechaInicio;
    }

    public String getDescFechaFin() {
        return descFechaFin;
    }

    public void setDescFechaFin(String descFechaFin) {
        this.descFechaFin = descFechaFin;
    }

    public String getDescFechaExaParcial() {
        return descFechaExaParcial;
    }

    public void setDescFechaExaParcial(String descFechaExaParcial) {
        this.descFechaExaParcial = descFechaExaParcial;
    }

    public String getDescFechaExaFinal() {
        return descFechaExaFinal;
    }

    public void setDescFechaExaFinal(String descFechaExaFinal) {
        this.descFechaExaFinal = descFechaExaFinal;
    }

    public String getDescDiaSemana() {
        return descDiaSemana;
    }

    public void setDescDiaSemana(String descDiaSemana) {
        this.descDiaSemana = descDiaSemana;
    }

    public String getDescAula() {
        return descAula;
    }

    public void setDescAula(String descAula) {
        this.descAula = descAula;
    }

    public String getHorarioDesde() {
        return horarioDesde;
    }

    public void setHorarioDesde(String horarioDesde) {
        this.horarioDesde = horarioDesde;
    }

    public String getHorarioHasta() {
        return horarioHasta;
    }

    public void setHorarioHasta(String horarioHasta) {
        this.horarioHasta = horarioHasta;
    }

    public String getDescPlanCurso() {
        return descPlanCurso;
    }

    public void setDescPlanCurso(String descPlanCurso) {
        this.descPlanCurso = descPlanCurso;
    }

    public String getDescSede() {
        return descSede;
    }

    public void setDescSede(String descSede) {
        this.descSede = descSede;
    }

    public String getDescTurno() {
        return descTurno;
    }

    public void setDescTurno(String descTurno) {
        this.descTurno = descTurno;
    }
}