package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.utic.webapp.gestion.entities.Carrera;

import java.util.List;

@RequestScoped
public class CarreraRepository extends AbstractCrudRepository<Carrera>{
    @Override
    protected String select() {
        return "SELECT r FROM Carrera r";
    }
}
