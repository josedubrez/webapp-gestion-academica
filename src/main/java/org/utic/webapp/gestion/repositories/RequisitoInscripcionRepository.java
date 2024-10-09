package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.RequisitoInscripcion;

import java.util.List;

@RequestScoped
public class RequisitoInscripcionRepository extends AbstractCrudRepository<RequisitoInscripcion>{
    @Override
    protected String select() {
        return "SELECT r FROM RequisitoInscripcion r " +
                "LEFT OUTER JOIN FETCH r.malla ";
    }

    public List<RequisitoInscripcion> getAllByMalla(Malla malla){
        return super.em.createQuery(select() + " WHERE r.malla.id = :id_malla " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_malla", malla.getId())
                .getResultList();
    }
}
