package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.PlanCurso;

@RequestScoped
@Named("planCursoConverter")
public class PlanCursoConverter extends AbstractEntityConverter<PlanCurso>{
}
