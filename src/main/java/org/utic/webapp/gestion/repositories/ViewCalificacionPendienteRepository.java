package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.ViewCalificacionPendiente;

import java.util.List;

@RequestScoped
public class ViewCalificacionPendienteRepository extends AbstractViewRepository<ViewCalificacionPendiente>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewCalificacionPendiente r "+
                "LEFT OUTER JOIN FETCH r.planCurso "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.materia "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla.carrera "+
                "LEFT OUTER JOIN FETCH r.planCurso.turno "+
                "LEFT OUTER JOIN FETCH r.planCurso.sede "+
                "LEFT OUTER JOIN FETCH r.docente "+
                "LEFT OUTER JOIN FETCH r.alumno ";
    }

    public List<ViewCalificacionPendiente> getAllByDocente(Docente docente){
        return super.em.createQuery(select() + " WHERE r.docente.id = :id_docente "
                                                + " ORDER BY r.alumno.apellido ASC, r.alumno.nombre ASC", super.entityClass)
                .setParameter("id_docente", docente.getId())
                .getResultList();
    }
}
