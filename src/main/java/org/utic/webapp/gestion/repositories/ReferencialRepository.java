package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class ReferencialRepository extends AbstractCrudRepository<Referencial>{

    @Override
    protected String select() {
        return "SELECT r FROM Referencial r " +
                       "LEFT OUTER JOIN FETCH r.mallaDet " +
                       "LEFT OUTER JOIN FETCH r.materia ";
    }

    public List<Referencial> getAllByMallaDet(MallaDet mallaDet){
        return super.em.createQuery(select() + " WHERE r.mallaDet.id = :id_malla_det " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_malla_det", mallaDet.getId())
                .getResultList();
    }
}
