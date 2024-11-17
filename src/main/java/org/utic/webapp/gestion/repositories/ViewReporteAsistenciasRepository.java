package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.time.LocalDate;
import java.util.List;

@RequestScoped
public class ViewReporteAsistenciasRepository extends AbstractViewRepository<ViewReporteAsistencias>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteAsistencias r " +
                "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.planCurso ";
    }

    public List<ViewReporteAsistencias> getAllByCustom(LocalDate fechaDesde,
                                                      LocalDate fechaHasta,
                                                      Alumno alumno,
                                                      Docente docente,
                                                      PlanCurso planCurso){

        StringBuilder queryBuilder = new StringBuilder("SELECT r FROM ViewReporteAsistencias ")
                .append(" r WHERE r.fecha BETWEEN :fecha_desde AND :fecha_hasta");

        if (alumno != null) {
            queryBuilder.append(" AND r.alumno.id = :id_alumno");
        }
        if (docente != null) {
            queryBuilder.append(" AND r.docente.id = :id_docente");
        }
        if (planCurso != null) {
            queryBuilder.append(" AND r.planCurso.id = :id_plan_curso");
        }
        queryBuilder.append(" ORDER BY r.id ASC");

        // Crear consulta
        var query = super.em.createQuery(queryBuilder.toString(), super.entityClass)
                .setParameter("fecha_desde", fechaDesde)
                .setParameter("fecha_hasta", fechaHasta);

        // Establecer parámetros opcionales
        if (alumno != null) {
            query.setParameter("id_alumno", alumno.getId());
        }
        if (docente != null) {
            query.setParameter("id_docente", docente.getId());
        }
        if (planCurso != null) {
            query.setParameter("id_plan_curso", planCurso.getId());
        }
        return query.getResultList();
    }
}