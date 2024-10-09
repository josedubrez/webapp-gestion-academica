package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Postulante;
import org.utic.webapp.gestion.entities.RequisitoDocenteDet;

import java.util.List;

@RequestScoped
public class RequisitoDocenteDetRepository extends AbstractCrudRepository<RequisitoDocenteDet>{
    @Override
    protected String select() {
        return "SELECT r FROM RequisitoDocenteDet r LEFT OUTER JOIN FETCH r.requisitoDocente";
    }

    public List<RequisitoDocenteDet> getAllByPostulante(Postulante postulante){
        return super.em.createQuery(select() + " WHERE r.postulante.id = :id_postulante " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_postulante", postulante.getId())
                .getResultList();
    }
}
