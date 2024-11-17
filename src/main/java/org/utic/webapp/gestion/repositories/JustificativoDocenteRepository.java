package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.JustificativoDocente;
import org.utic.webapp.gestion.entities.PermisoDocente;

@RequestScoped
public class JustificativoDocenteRepository extends AbstractCrudRepository<JustificativoDocente>{
    @Override
    protected String select() {
        return "SELECT r FROM JustificativoDocente r LEFT OUTER JOIN FETCH r.docente";
    }
}
