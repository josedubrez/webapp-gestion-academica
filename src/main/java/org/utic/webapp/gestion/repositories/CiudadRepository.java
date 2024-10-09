package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Ciudad;

@RequestScoped
public class CiudadRepository extends AbstractCrudRepository<Ciudad>{
    @Override
    protected String select() {
        return "SELECT r FROM Ciudad r";
    }
}
