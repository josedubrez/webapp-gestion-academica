package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Malla;

@RequestScoped
@Named("mallaConverter")
public class MallaConverter extends AbstractEntityConverter<Malla>{
}
