package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class ViewConfirmarClaseRepository extends AbstractViewRepository<ViewConfirmarClase>{

    @Override
    protected String select() {
        return "SELECT r FROM ViewConfirmarClase r "+
                "LEFT OUTER JOIN FETCH r.planCurso "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.materia "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla.carrera "+
                "LEFT OUTER JOIN FETCH r.planCurso.turno "+
                "LEFT OUTER JOIN FETCH r.planCurso.sede "+
                "LEFT OUTER JOIN FETCH r.docente "+
                "LEFT OUTER JOIN FETCH r.planCursoHorario "+
                "LEFT OUTER JOIN FETCH r.planCursoHorario.aula ";
    }

    public List<ViewConfirmarClase> getAllByDocente(Docente docente){
        return super.em.createQuery(select() + " WHERE r.docente.id = :id_docente " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_docente", docente.getId())
                .getResultList();
    }
}
