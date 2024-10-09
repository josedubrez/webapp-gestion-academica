package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Postulante;

@RequestScoped
public class PostulanteRepository extends AbstractCrudRepository<Postulante>{
    @Override
    protected String select() {
        return "SELECT r FROM Postulante r";
    }
}
