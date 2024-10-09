package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Turno;

@RequestScoped
@Named("turnoConverter")
public class TurnoConverter extends AbstractEntityConverter<Turno>{
}
