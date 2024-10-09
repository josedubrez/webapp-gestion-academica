package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Seccion;

@RequestScoped
@Named("seccionConverter")
public class SeccionConverter extends AbstractEntityConverter<Seccion>{
}
