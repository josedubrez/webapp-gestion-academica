package org.utic.webapp.gestion.repositories;

import org.utic.webapp.gestion.utils.Mensaje;

import java.util.List;

public interface CrudRepository<T> {
    List<T> getAll();
    T getById(Long id);
    Mensaje save(T t);
    Mensaje delete(T t);
}
