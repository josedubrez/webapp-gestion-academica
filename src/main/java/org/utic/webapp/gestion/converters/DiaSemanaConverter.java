package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.DiaSemana;

@RequestScoped
@Named("diaSemanaConverter")
public class DiaSemanaConverter extends AbstractEntityConverter<DiaSemana>{
}
