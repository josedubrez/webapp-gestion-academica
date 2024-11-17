package org.utic.webapp.gestion.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.utic.webapp.gestion.entities.EntityWithId;

import java.util.List;

public abstract class AbstractViewRepository<T extends EntityWithId> implements ViewRepository<T>{
    @Inject
    protected EntityManager em;

    protected Class<T> entityClass;

    @Override
    public List<T> getAll() {
        return em.createQuery(select() + " ORDER BY r.id ASC", entityClass).getResultList();
    }

    @Override
    public T getById(Long id) {
        return em.createQuery(select() + " WHERE r.id = :id", entityClass)
                .setParameter("id", id)
                .getSingleResult();
    }

    protected abstract String select();
}
