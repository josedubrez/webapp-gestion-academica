package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.EscalaCalificacion;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.MallaDet;

import java.util.List;

@RequestScoped
public class EscalaCalificacionRepository extends AbstractCrudRepository<EscalaCalificacion>{
    @Override
    protected String select() {
        return "SELECT r FROM EscalaCalificacion r " +
                "LEFT OUTER JOIN FETCH r.malla ";
    }

    public List<EscalaCalificacion> getAllByMalla(Malla malla){
        return super.em.createQuery(select() + " WHERE r.malla.id = :id_malla " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_malla", malla.getId())
                .getResultList();
    }
}
