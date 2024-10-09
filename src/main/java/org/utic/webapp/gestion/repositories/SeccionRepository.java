package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Seccion;

@RequestScoped
public class SeccionRepository extends AbstractCrudRepository<Seccion>{
    @Override
    protected String select() {
        return "SELECT r FROM Seccion r";
    }
}
