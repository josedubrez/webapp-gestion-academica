package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class ViewReporteCalificacionesRepository extends AbstractViewRepository<ViewReporteCalificaciones>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteCalificaciones r ";
    }

    public List<ViewReporteCalificaciones> getAllByCustom(Malla malla,
                                                          Integer nroSemestre,
                                                          MallaDet mallaDet,
                                                          Sede sede,
                                                          Turno turno,
                                                          Docente docente,
                                                          Alumno alumno){

        StringBuilder queryBuilder = new StringBuilder(select()).append("WHERE 1 = 1");

        if (malla != null) {
            queryBuilder.append(" AND r.malla.id = :id_malla");
            queryBuilder.append(" AND r.nroSemestre = :nro_semestre");
        }
        if (mallaDet != null) {
            queryBuilder.append(" AND r.mallaDet.id = :id_malla_det");
        }
        if (sede != null) {
            queryBuilder.append(" AND r.sede.id = :id_sede");
        }
        if (turno != null) {
            queryBuilder.append(" AND r.turno.id = :id_turno");
        }
        if (docente != null) {
            queryBuilder.append(" AND r.docente.id = :id_docente");
        }
        if (alumno != null) {
            queryBuilder.append(" AND r.alumno.id = :id_alumno");
        }
        queryBuilder.append(" ORDER BY r.id ASC");

        // Crear consulta
        var query = super.em.createQuery(queryBuilder.toString(), super.entityClass);

        // Establecer parámetros opcionales
        if (malla != null) {
            query.setParameter("id_malla", malla.getId());
            query.setParameter("nro_semestre", nroSemestre);
        }
        if (mallaDet != null) {
            query.setParameter("id_malla_det", mallaDet.getId());
        }
        if (sede != null) {
            query.setParameter("id_sede", sede.getId());
        }
        if (turno != null) {
            query.setParameter("id_turno", turno.getId());
        }
        if (docente != null) {
            query.setParameter("id_docente", docente.getId());
        }
        if (alumno != null) {
            query.setParameter("id_alumno", alumno.getId());
        }
        return query.getResultList();
    }
}