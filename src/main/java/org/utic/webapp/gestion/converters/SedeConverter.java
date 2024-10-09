package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Sede;

@RequestScoped
@Named("sedeConverter")
public class SedeConverter extends AbstractEntityConverter<Sede>{
}
