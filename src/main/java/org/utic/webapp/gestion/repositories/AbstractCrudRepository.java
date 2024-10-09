package org.utic.webapp.gestion.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.utic.webapp.gestion.entities.EntityWithId;
import org.utic.webapp.gestion.utils.Mensaje;
import org.utic.webapp.gestion.utils.Validaciones;

import java.util.List;

public abstract class AbstractCrudRepository<T extends EntityWithId> implements CrudRepository<T>{

    @Inject
    protected EntityManager em;

    protected Class<T> entityClass;

    @Override
    public List<T> getAll() {
        return em.createQuery(select() + " " + "ORDER BY r.id DESC", entityClass).getResultList();
    }

    @Override
    public T getById(Long id) {
        return em.createQuery(select() + " WHERE r.id = :id ORDER BY r.id DESC", entityClass)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Mensaje save(T t) {
        try {
            if (t.getId() != null && t.getId() > 0) {
                em.merge(t);
                em.flush();
            } else {
                em.persist(t);
            }
        }catch (PersistenceException e){
            return Validaciones.getMensaje(e.getCause());
        }

        return new Mensaje(true, "", "");
    }

    @Override
    public Mensaje delete(T t) {
        try {
            em.remove(em.merge(t));
            em.flush();
        }catch (PersistenceException e){
            return Validaciones.getMensaje(e.getCause());
        }
        return new Mensaje(true, "", "");
    }

    protected abstract String select();
}
