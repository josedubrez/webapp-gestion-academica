package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Turno;

@RequestScoped
public class TurnoRepository extends AbstractCrudRepository<Turno>{
    @Override
    protected String select() {
        return "SELECT r FROM Turno r";
    }
}
