package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.ExamenDet;

import java.util.List;

@RequestScoped
public class ExamenDetRepository extends AbstractCrudRepository<ExamenDet>{

    @Override
    protected String select() {
        return "SELECT r FROM ExamenDet r " +
                "LEFT OUTER JOIN FETCH r.examen " +
                "LEFT OUTER JOIN FETCH r.alumno ";
    }

    public List<ExamenDet> getAllByExamen(Examen examen){
        return super.em.createQuery(select() + " WHERE r.examen.id = :id_examen " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_examen", examen.getId())
                .getResultList();
    }
}
