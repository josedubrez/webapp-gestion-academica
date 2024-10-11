package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Piso;

@RequestScoped
@Named("pisoConverter")
public class PisoConverter extends AbstractEntityConverter<Piso>{
}
