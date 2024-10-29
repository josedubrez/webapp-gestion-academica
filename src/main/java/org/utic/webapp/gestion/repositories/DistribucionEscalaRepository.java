package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.DistribucionEscala;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@RequestScoped
public class DistribucionEscalaRepository extends AbstractCrudRepository<DistribucionEscala>{

    @Override
    protected String select() {
        return "SELECT r FROM DistribucionEscala r";
    }

    public List<DistribucionEscala> getAllByPlanCurso(PlanCurso planCurso){
        return super.em.createQuery(select() + " WHERE r.planCurso.id = :id_plan_curso " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_plan_curso", planCurso.getId())
                .getResultList();
    }
}
