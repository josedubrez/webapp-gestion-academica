package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Sede;

@RequestScoped
public class SedeRepository extends AbstractCrudRepository<Sede>{

    @Override
    protected String select() {
        return "SELECT r FROM Sede r LEFT OUTER JOIN FETCH r.ciudad";
    }
}