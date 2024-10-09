package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import org.utic.webapp.gestion.entities.Carrera;

@RequestScoped
@Named("carreraConverter")
public class CarreraConverter extends AbstractEntityConverter<Carrera> {
}
