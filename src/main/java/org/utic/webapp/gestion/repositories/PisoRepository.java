package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Piso;

@RequestScoped
public class PisoRepository extends AbstractCrudRepository<Piso>{
    @Override
    protected String select() {
        return "SELECT r FROM Piso r";
    }
}
