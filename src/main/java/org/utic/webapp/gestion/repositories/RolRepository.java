package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Rol;

@RequestScoped
public class RolRepository extends AbstractCrudRepository<Rol>{
    @Override
    protected String select() {
        return "SELECT r FROM Rol r";
    }
}
