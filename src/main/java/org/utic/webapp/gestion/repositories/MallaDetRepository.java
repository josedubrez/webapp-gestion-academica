package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.MallaDet;

import java.util.List;

@RequestScoped
public class MallaDetRepository extends AbstractCrudRepository<MallaDet>{
    @Override
    protected String select() {
        return "SELECT r FROM MallaDet r " +
                        "LEFT OUTER JOIN FETCH r.malla "+
                        "LEFT OUTER JOIN FETCH r.malla.carrera "+
                        "LEFT OUTER JOIN FETCH r.materia "+
                        "LEFT OUTER JOIN FETCH r.mallaDetRef";
    }

    public List<MallaDet> getAllByMalla(Malla malla){
        return super.em.createQuery(select() + " WHERE r.malla.id = :id_malla " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_malla", malla.getId())
                .getResultList();
    }
}
