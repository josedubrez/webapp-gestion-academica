package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Materia;


@RequestScoped
public class MateriaRepository extends AbstractCrudRepository<Materia>{
    @Override
    protected String select() {
        return "SELECT r FROM Materia r";
    }
}