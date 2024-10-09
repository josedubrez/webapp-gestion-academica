package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Alumno;

@RequestScoped
public class AlumnoRepository extends AbstractCrudRepository<Alumno>{
    @Override
    protected String select() {
        return "SELECT r FROM Alumno r";
    }
}
