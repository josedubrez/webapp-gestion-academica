package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.ViewReporteMallas;

import java.util.List;

@RequestScoped
public class ViewReporteMallasRepository extends AbstractViewRepository<ViewReporteMallas>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteMallas r " +
                "LEFT OUTER JOIN FETCH r.malla ";
    }

    public List<ViewReporteMallas> getAllByCustom(Malla malla){
        return super.em.createQuery(select()
                        + " WHERE r.malla.id = :id_malla "
                        + " ORDER BY r.id ASC", super.entityClass)
                .setParameter("id_malla", malla.getId())
                .getResultList();
    }
}