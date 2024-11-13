package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.TrabajoClase;
import org.utic.webapp.gestion.entities.TrabajoClaseDet;
import org.utic.webapp.gestion.entities.TrabajoPractico;

import java.util.List;

@RequestScoped
public class TrabajoClaseDetRepository extends AbstractCrudRepository<TrabajoClaseDet>{

    @Override
    protected String select() {
        return "SELECT r FROM TrabajoClaseDet r " +
                "LEFT OUTER JOIN FETCH r.trabajoClase " +
                "LEFT OUTER JOIN FETCH r.alumno ";
    }

    public List<TrabajoClaseDet> getAllByTrabajoClase(TrabajoClase trabajoClase){
        return super.em.createQuery(select() + " WHERE r.trabajoClase.id = :id_trabajo_clase " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_trabajo_clase", trabajoClase.getId())
                .getResultList();
    }
}
