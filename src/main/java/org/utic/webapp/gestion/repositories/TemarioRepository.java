package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class TemarioRepository extends AbstractCrudRepository<Temario>{

    @Override
    protected String select() {
        return "SELECT r FROM Temario r " +
                       "LEFT OUTER JOIN FETCH r.mallaDet " +
                       "LEFT OUTER JOIN FETCH r.temarioPadre ";
    }

    public List<Temario> getAllByMallaDet(MallaDet mallaDet){
        return super.em.createQuery(select() + " WHERE r.mallaDet.id = :id_malla_det " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_malla_det", mallaDet.getId())
                .getResultList();
    }
}
