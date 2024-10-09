package org.utic.webapp.gestion.utils;

import jakarta.validation.ConstraintViolationException;

import java.sql.SQLException;

public class Validaciones {
    public static Mensaje getMensaje(Throwable cause){
        Mensaje mensaje = null;
        while (cause != null) {
            if (cause instanceof SQLException) {
                SQLException sqlException = (SQLException) cause;
                String mensajeError = sqlException.getMessage();
                mensaje = new Mensaje(false, "Error de Validacion", mensajeError);
                break;
            }
            cause = cause.getCause();
        }
        return mensaje;
    }
}
