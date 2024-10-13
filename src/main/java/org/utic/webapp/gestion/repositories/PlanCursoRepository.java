package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class PlanCursoRepository extends AbstractCrudRepository<PlanCurso>{
    @Override
    protected String select() {
        return "SELECT r FROM PlanCurso r " +
                "LEFT OUTER JOIN FETCH r.sede " +
                "LEFT OUTER JOIN FETCH r.turno " +
                "LEFT OUTER JOIN FETCH r.mallaDet " +
                "LEFT OUTER JOIN FETCH r.mallaDet.malla " +
                "LEFT OUTER JOIN FETCH r.mallaDet.materia " +
                "LEFT OUTER JOIN FETCH r.docente ";
    }

    public List<PlanCurso> getAllByDocente(Docente docente){
        return super.em.createQuery(select() + " WHERE r.docente.id = :id_docente " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_docente", docente.getId())
                .getResultList();
    }
}
