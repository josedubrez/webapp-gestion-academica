package org.utic.webapp.gestion.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.utic.webapp.gestion.utils.Cripto;

@Entity
@Table(name = "usuarios")
public class Usuario extends AbstractEntity<Usuario>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Column(name = "nro_cedula")
    private String nroCedula;

    @Override
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
        this.password = (this.id == null || !this.password.equals(password)) ? Cripto.generateHashMD5(password) : password;
    }

    public String getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(String nroCedula) {
        this.nroCedula = nroCedula;
    }
}
