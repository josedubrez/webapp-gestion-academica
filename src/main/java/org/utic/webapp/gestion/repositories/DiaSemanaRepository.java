package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.DiaSemana;

@RequestScoped
public class DiaSemanaRepository extends AbstractCrudRepository<DiaSemana>{
    @Override
    protected String select() {
        return "SELECT r FROM DiaSemana r";
    }
}
