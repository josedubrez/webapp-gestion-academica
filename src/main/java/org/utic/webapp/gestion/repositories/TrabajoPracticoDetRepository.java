package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.TrabajoPractico;
import org.utic.webapp.gestion.entities.TrabajoPracticoDet;

import java.util.List;

@RequestScoped
public class TrabajoPracticoDetRepository extends AbstractCrudRepository<TrabajoPracticoDet>{
    @Override
    protected String select() {
        return "SELECT r FROM TrabajoPracticoDet r " +
                "LEFT OUTER JOIN FETCH r.trabajoPractico " +
                "LEFT OUTER JOIN FETCH r.alumno ";
    }

    public List<TrabajoPracticoDet> getAllByTrabajoPractico(TrabajoPractico trabajoPractico){
        return super.em.createQuery(select() + " WHERE r.trabajoPractico.id = :id_trabajo_practico " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_trabajo_practico", trabajoPractico.getId())
                .getResultList();
    }
}
