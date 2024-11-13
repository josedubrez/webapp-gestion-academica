package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Calificacion;
import org.utic.webapp.gestion.entities.PlanCurso;

import java.util.List;

@RequestScoped
public class CalificacionRepository extends AbstractCrudRepository<Calificacion>{
    @Override
    protected String select() {
        return "SELECT r FROM Calificacion r "+
                "LEFT OUTER JOIN FETCH r.planCurso "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.materia "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla.carrera "+
                "LEFT OUTER JOIN FETCH r.planCurso.turno "+
                "LEFT OUTER JOIN FETCH r.planCurso.sede "+
                "LEFT OUTER JOIN FETCH r.alumno ";
    }

    public List<Calificacion> getAllByPlanCurso(PlanCurso planCurso){
        return super.em.createQuery(select() + " WHERE r.planCurso.id = :id_plan_curso "
                                                + " ORDER BY r.alumno.apellido ASC, r.alumno.nombre ASC", super.entityClass)
                .setParameter("id_plan_curso", planCurso.getId())
                .getResultList();
    }
}
