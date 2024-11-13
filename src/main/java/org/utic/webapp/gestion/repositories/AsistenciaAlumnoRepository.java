package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequestScoped
public class AsistenciaAlumnoRepository extends AbstractCrudRepository<AsistenciaAlumno>{
    @Override
    protected String select() {
        return "SELECT r FROM AsistenciaAlumno r " +
                "LEFT OUTER JOIN FETCH r.clase " +
                "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.clase.planCurso "+
                "LEFT OUTER JOIN FETCH r.clase.planCurso.mallaDet "+
                "LEFT OUTER JOIN FETCH r.clase.planCurso.mallaDet.materia ";
    }

    public List<AsistenciaAlumno> getAllByClase(Clase clase){
        return super.em.createQuery(select() + " WHERE r.clase.id = :id_clase "
                                                + " ORDER BY r.alumno.apellido ASC, r.alumno.nombre ASC", super.entityClass)
                .setParameter("id_clase", clase.getId())
                .getResultList();
    }

    public List<AsistenciaAlumno> getAllByDocente(Docente docente){
        return super.em.createQuery(select() + " WHERE r.clase.docente.id = :id_docente "
                                                + " AND :fecha_actual = r.clase.fecha "
                                                + " AND :hora_actual BETWEEN r.clase.horarioDesde and r.clase.horarioHasta "
                                                + "ORDER BY r.alumno.apellido ASC, r.alumno.nombre ASC", super.entityClass)
                .setParameter("id_docente", docente.getId())
                .setParameter("fecha_actual", LocalDate.now())
                .setParameter("hora_actual", LocalTime.now())
                .getResultList();
    }
}
