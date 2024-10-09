package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.MallaDet;
import org.utic.webapp.gestion.entities.PlanCurso;
import org.utic.webapp.gestion.entities.PlanCursoHorario;

import java.util.List;

@RequestScoped
public class PlanCursoHorarioRepository extends AbstractCrudRepository<PlanCursoHorario>{

    @Override
    protected String select() {
        return "SELECT r FROM PlanCursoHorario r " +
                "LEFT OUTER JOIN FETCH r.planCurso " +
                "LEFT OUTER JOIN FETCH r.diaSemana " +
                "LEFT OUTER JOIN FETCH r.aula";
    }

    public List<PlanCursoHorario> getAllByPlanCurso(PlanCurso planCurso){
        return super.em.createQuery(select() + " WHERE r.planCurso.id = :id_plan_curso " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_plan_curso", planCurso.getId())
                .getResultList();
    }
}
