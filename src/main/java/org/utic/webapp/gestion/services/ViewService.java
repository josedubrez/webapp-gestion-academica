package org.utic.webapp.gestion.services;

import java.util.List;

public interface ViewService<T>{
    List<T> getAll();
    T getById(Long id);
}
