package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class InscripcionPlanCursoRepository extends AbstractCrudRepository<InscripcionPlanCurso>{
    @Override
    protected String select() {
        return "SELECT r FROM InscripcionPlanCurso r " +
               "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.planCurso "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla.carrera "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.materia "+
                "LEFT OUTER JOIN FETCH r.planCurso.turno "+
                "LEFT OUTER JOIN FETCH r.planCurso.docente "+
                "LEFT OUTER JOIN FETCH r.planCurso.sede ";
    }

    public List<InscripcionPlanCurso> getAllByAlumno(Alumno alumno){
        return super.em.createQuery(select() + " WHERE r.alumno.id = :id_alumno " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_alumno", alumno.getId())
                .getResultList();
    }

}
