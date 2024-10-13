package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.JustificativoAlumno;
import org.utic.webapp.gestion.entities.SancionAlumno;

@RequestScoped
public class SancionAlumnoRepository extends AbstractCrudRepository<SancionAlumno>{
    @Override
    protected String select() {
        return "SELECT r FROM SancionAlumno r " +
                "LEFT OUTER JOIN FETCH r.alumno "+
                "LEFT OUTER JOIN FETCH r.malla ";
    }
}
