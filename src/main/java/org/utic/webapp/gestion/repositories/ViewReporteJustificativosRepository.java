package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.time.LocalDate;
import java.util.List;

@RequestScoped
public class ViewReporteJustificativosRepository extends AbstractViewRepository<ViewReporteJustificativos>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteJustificativos r ";
    }

    public List<ViewReporteJustificativos> getAllByCustom(LocalDate fechaDesde,
                                                      LocalDate fechaHasta,
                                                      Docente docente){

        StringBuilder queryBuilder = new StringBuilder(select()).append("WHERE r.fecha BETWEEN :fecha_desde AND :fecha_hasta");

        if (docente != null) {
            queryBuilder.append(" AND r.docente.id = :id_docente");
        }
        queryBuilder.append(" ORDER BY r.id ASC");

        // Crear consulta
        var query = super.em.createQuery(queryBuilder.toString(), super.entityClass)
                .setParameter("fecha_desde", fechaDesde)
                .setParameter("fecha_hasta", fechaHasta);

        // Establecer parámetros opcionales
        if (docente != null) {
            query.setParameter("id_docente", docente.getId());
        }

        return query.getResultList();
    }
}