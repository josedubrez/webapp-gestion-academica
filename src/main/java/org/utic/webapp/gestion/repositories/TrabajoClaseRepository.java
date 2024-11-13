package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.TrabajoClase;

import java.util.List;

@RequestScoped
public class TrabajoClaseRepository extends AbstractCrudRepository<TrabajoClase>{
    @Override
    protected String select() {
        return "SELECT r FROM TrabajoClase r";
    }

    public List<TrabajoClase> getAllByClase(Clase clase) {
        return super.em.createQuery(select() + " WHERE r.clase.id = :id_clase " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_clase", clase.getId())
                .getResultList();
    }
}