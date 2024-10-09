package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.RequisitoDocente;

@RequestScoped
public class RequisitoDocenteRepository extends AbstractCrudRepository<RequisitoDocente>{
    @Override
    protected String select() {
        return "SELECT r FROM RequisitoDocente r";
    }
}
