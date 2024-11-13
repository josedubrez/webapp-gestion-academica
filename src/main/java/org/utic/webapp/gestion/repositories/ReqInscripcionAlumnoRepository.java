package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.*;
import org.utic.webapp.gestion.entities.Alumno;

import java.util.List;

@RequestScoped
public class ReqInscripcionAlumnoRepository extends AbstractCrudRepository<ReqInscripcionAlumno>{
    @Override
    protected String select() {
        return "SELECT r FROM ReqInscripcionAlumno r " +
                "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.requisito";
    }

    public List<ReqInscripcionAlumno> getAllByAlumno(Alumno alumno){
        return super.em.createQuery(select() + " WHERE r.alumno.id = :id_alumno " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_alumno", alumno.getId())
                .getResultList();
    }

}
