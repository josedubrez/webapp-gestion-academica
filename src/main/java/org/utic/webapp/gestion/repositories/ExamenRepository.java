package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Examen;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@RequestScoped
public class ExamenRepository extends AbstractCrudRepository<Examen>{
    @Override
    protected String select() {
        return "SELECT r FROM Examen r";
    }

    public List<Examen> getAllByPlanCurso(PlanCurso planCurso){
        return super.em.createQuery(select() + " WHERE r.planCurso.id = :id_plan_curso " + "ORDER BY r.id ASC", super.entityClass)
                .setParameter("id_plan_curso", planCurso.getId())
                .getResultList();
    }
}
