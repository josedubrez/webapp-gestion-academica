package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.utic.webapp.gestion.entities.Malla;

import java.util.List;

@RequestScoped
public class MallaRepository extends AbstractCrudRepository<Malla> {

    @Override
    protected String select() {
        return "SELECT r FROM Malla r LEFT OUTER JOIN FETCH r.carrera";
    }
}
