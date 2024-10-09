package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.InscripcionMalla;
import org.utic.webapp.gestion.entities.Alumno;

import java.util.List;

@RequestScoped
public class InscripcionMallaRepository extends AbstractCrudRepository<InscripcionMalla>{
    @Override
    protected String select() {
        return "SELECT r FROM InscripcionMalla r " +
                "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.malla "+
                "LEFT OUTER JOIN FETCH r.sede "+
                "LEFT OUTER JOIN FETCH r.turno";
    }

    public List<InscripcionMalla> getAllByAlumno(Alumno alumno){
        return super.em.createQuery(select() + " WHERE r.alumno.id = :id_alumno " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_alumno", alumno.getId())
                .getResultList();
    }
}
