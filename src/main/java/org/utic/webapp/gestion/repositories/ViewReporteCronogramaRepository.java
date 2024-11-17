package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.time.LocalDate;
import java.util.List;

@RequestScoped
public class ViewReporteCronogramaRepository extends AbstractViewRepository<ViewReporteCronograma>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteCronograma r ";
    }

    public List<ViewReporteCronograma> getAllByCustom(Malla malla,
                                                      Integer nroSemestre,
                                                      PlanCurso planCurso,
                                                      Docente docente){

        StringBuilder queryBuilder = new StringBuilder(select()).append("WHERE 1 = 1");

        if (malla != null) {
            queryBuilder.append(" AND r.malla.id = :id_malla");
            queryBuilder.append(" AND r.nroSemestre = :nro_semestre");
        }
        if (docente != null) {
            queryBuilder.append(" AND r.docente.id = :id_docente");
        }
        if (planCurso != null) {
            queryBuilder.append(" AND r.planCurso.id = :id_plan_curso");
        }
        queryBuilder.append(" ORDER BY r.id ASC");

        // Crear consulta
        var query = super.em.createQuery(queryBuilder.toString(), super.entityClass);

        // Establecer parámetros opcionales
        if (malla != null) {
            query.setParameter("id_malla", malla.getId());
            query.setParameter("nro_semestre", nroSemestre);
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