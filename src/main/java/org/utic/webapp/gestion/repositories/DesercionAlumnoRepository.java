package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.DesercionAlumno;

@RequestScoped
public class DesercionAlumnoRepository extends AbstractCrudRepository<DesercionAlumno>{
    @Override
    protected String select() {
        return "SELECT r FROM DesercionAlumno r " +
                "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.malla ";
    }
}
