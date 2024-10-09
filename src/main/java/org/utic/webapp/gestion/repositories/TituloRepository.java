package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Titulo;

@RequestScoped
public class TituloRepository extends AbstractCrudRepository<Titulo>{
    @Override
    protected String select() {
        return "SELECT r FROM Titulo r";
    }
}
