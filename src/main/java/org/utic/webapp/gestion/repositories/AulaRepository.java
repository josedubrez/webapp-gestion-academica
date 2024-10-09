package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Aula;
import org.utic.webapp.gestion.utils.Mensaje;

@RequestScoped
public class AulaRepository extends AbstractCrudRepository<Aula>{
    @Override
    protected String select() {
        return "SELECT r FROM Aula r " +
                "LEFT OUTER JOIN FETCH r.piso " +
                "LEFT OUTER JOIN FETCH r.seccion ";
    }

    @Override
    public Mensaje save(Aula aula) {
        System.out.println("AULA_REPOSITORY.SAVE: " + aula + " " + aula.getPiso() + " " + aula.getSeccion());
        return super.save(aula);
    }
}
