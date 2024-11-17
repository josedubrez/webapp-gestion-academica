package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.Docente;
import org.utic.webapp.gestion.entities.Malla;
import org.utic.webapp.gestion.entities.ViewReporteContrato;
import org.utic.webapp.gestion.entities.ViewReporteMallas;

import java.util.List;

@RequestScoped
public class ViewReporteContratoRepository extends AbstractViewRepository<ViewReporteContrato>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteContrato r ";
    }

    public List<ViewReporteContrato> getAllByCustom(Docente docente){
        return super.em.createQuery(select()
                        + " WHERE r.docente.id = :id_docente "
                        + " ORDER BY r.id ASC", super.entityClass)
                .setParameter("id_docente", docente.getId())
                .getResultList();
    }
}