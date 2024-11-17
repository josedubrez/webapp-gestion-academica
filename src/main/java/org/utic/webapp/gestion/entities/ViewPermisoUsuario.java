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

    private Boolean secretaria;
    private Boolean coordinacion;
    private Boolean directivo;

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

    public Boolean getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Boolean secretaria) {
        this.secretaria = secretaria;
    }

    public Boolean getCoordinacion() {
        return coordinacion;
    }

    public void setCoordinacion(Boolean coordinacion) {
        this.coordinacion = coordinacion;
    }

    public Boolean getDirectivo() {
        return directivo;
    }

    public void setDirectivo(Boolean directivo) {
        this.directivo = directivo;
    }
}
