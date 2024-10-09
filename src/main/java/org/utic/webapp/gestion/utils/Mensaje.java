package org.utic.webapp.gestion.utils;

public class Mensaje{
    private boolean realizado;
    private String titulo;
    private String detalle;

    public Mensaje (boolean realizado, String titulo, String detalle){
        this.realizado = realizado;
        this.titulo = titulo;
        this.detalle = detalle;
        System.out.println("CONSTRUCTOR_MENSAJE: "+ realizado + titulo + detalle);
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
