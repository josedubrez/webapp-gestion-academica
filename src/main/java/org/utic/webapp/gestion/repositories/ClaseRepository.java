package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Clase;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@RequestScoped
public class ClaseRepository extends AbstractCrudRepository<Clase>{
    @Override
    protected String select() {
        return "SELECT r FROM Clase r "+
                "LEFT OUTER JOIN FETCH r.planCurso "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.materia "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla.carrera "+
                "LEFT OUTER JOIN FETCH r.planCurso.turno "+
                "LEFT OUTER JOIN FETCH r.planCurso.sede "+
                "LEFT OUTER JOIN FETCH r.docente "+
                "LEFT OUTER JOIN FETCH r.aula ";
    }

    public List<Clase> getAllByPlanCurso(PlanCurso planCurso){
        return super.em.createQuery(select() + " WHERE r.planCurso.id = :id_plan_curso " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_plan_curso", planCurso.getId())
                .getResultList();
    }
}
