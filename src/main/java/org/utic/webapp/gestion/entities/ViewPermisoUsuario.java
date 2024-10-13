package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "v_usuarios")
public class ViewPermisoUsuario extends AbstractEntity<ViewPermisoUsuario>{
    @Id
    private Long id;
    private String username;
    private String password;

    private Boolean seguridad;
    private Boolean referencial;
    private Boolean academico;
    private Boolean documental;
    private Boolean operativo;
    private Boolean conectado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_docente")
    private Docente docente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(Boolean seguridad) {
        this.seguridad = seguridad;
    }

    public Boolean getReferencial() {
        return referencial;
    }

    public void setReferencial(Boolean referencial) {
        this.referencial = referencial;
    }

    public Boolean getAcademico() {
        return academico;
    }

    public void setAcademico(Boolean academico) {
        this.academico = academico;
    }

    public Boolean getDocumental() {
        return documental;
    }

    public void setDocumental(Boolean documental) {
        this.documental = documental;
    }

    public Boolean getOperativo() {
        return operativo;
    }

    public void setOperativo(Boolean operativo) {
        this.operativo = operativo;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Boolean getEsDocente() {
        return (docente != null);
    }
}
