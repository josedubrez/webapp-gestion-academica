package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Feriado;

@RequestScoped
public class FeriadoRepository extends AbstractCrudRepository<Feriado>{
    @Override
    protected String select() {
        return "SELECT r FROM Feriado r "+
                "LEFT OUTER JOIN FETCH r.sede ";
    }
}
