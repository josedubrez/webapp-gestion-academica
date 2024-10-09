package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.ContratoDocente;
import org.utic.webapp.gestion.entities.Docente;

import java.util.List;

@RequestScoped
public class ContratoDocenteRepository extends AbstractCrudRepository<ContratoDocente> {
    @Override
    protected String select() {
        return "SELECT r FROM ContratoDocente r LEFT OUTER JOIN FETCH r.docente";
    }

    public List<ContratoDocente> getAllByDocente(Docente docente){
        return super.em.createQuery(select() + " WHERE r.docente.id = :id_docente " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_docente", docente.getId())
                .getResultList();
    }
}
