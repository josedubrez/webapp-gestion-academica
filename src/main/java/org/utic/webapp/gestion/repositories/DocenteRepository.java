package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Docente;

@RequestScoped
public class DocenteRepository extends AbstractCrudRepository<Docente>{
    @Override
    protected String select() {
        return "SELECT r FROM Docente r LEFT OUTER JOIN FETCH r.titulo";
    }
}
