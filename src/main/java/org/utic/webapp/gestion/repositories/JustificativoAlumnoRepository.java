package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.JustificativoAlumno;
import org.utic.webapp.gestion.entities.PermisoDocente;

@RequestScoped
public class JustificativoAlumnoRepository extends AbstractCrudRepository<JustificativoAlumno>{
    @Override
    protected String select() {
        return "SELECT r FROM JustificativoAlumno r LEFT OUTER JOIN FETCH r.alumno";
    }
}
