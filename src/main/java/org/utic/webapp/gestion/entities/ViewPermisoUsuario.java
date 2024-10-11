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
    private Boolean docente;
    private Boolean conectado;

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
        System.out.println("SET_USERNAME: " + username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("SET_PASSWORD: " + password);
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

    public Boolean getDocente() {
        return docente;
    }

    public void setDocente(Boolean docente) {
        this.docente = docente;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }
}
