package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.PermisoDocente;

@RequestScoped
public class PermisoDocenteRepository extends AbstractCrudRepository<PermisoDocente>{
    @Override
    protected String select() {
        return "SELECT r FROM PermisoDocente r LEFT OUTER JOIN FETCH r.docente";
    }
}
