package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.entities.TrabajoPractico;

import java.util.List;

@RequestScoped
public class TrabajoPracticoRepository extends AbstractCrudRepository<TrabajoPractico>{
    @Override
    protected String select() {
        return "SELECT r FROM TrabajoPractico r";
    }

    public List<TrabajoPractico> getAllByPlanCurso(PlanCurso planCurso){
        return super.em.createQuery(select() + " WHERE r.planCurso.id = :id_plan_curso " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_plan_curso", planCurso.getId())
                .getResultList();
    }
}
