package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.ViewReporteMallas;

@RequestScoped
public class ViewReporteMallasRepository extends AbstractViewRepository<ViewReporteMallas>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewReporteMallas r ORDER BY r.id ASC";
    }
}