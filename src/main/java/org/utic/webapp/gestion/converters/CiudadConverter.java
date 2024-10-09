package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Ciudad;

@RequestScoped
@Named("ciudadConverter")
public class CiudadConverter extends AbstractEntityConverter<Ciudad>{
}
