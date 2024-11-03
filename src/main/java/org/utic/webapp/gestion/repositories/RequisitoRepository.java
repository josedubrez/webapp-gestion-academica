package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Requisito;

@RequestScoped
public class RequisitoRepository extends AbstractCrudRepository<Requisito>{
    @Override
    protected String select() {
        return "SELECT r FROM Requisito r ";
    }

}
