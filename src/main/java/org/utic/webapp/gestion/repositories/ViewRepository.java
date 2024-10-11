package org.utic.webapp.gestion.repositories;

import java.util.List;

public interface ViewRepository<T> {
    List<T> getAll();
    T getById(Long id);
}
