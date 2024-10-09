package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

public interface CrudService<T> {
    List<T> getAll();
    T getById(Long id);
    Mensaje save(T t);
    Mensaje delete(T t);
}