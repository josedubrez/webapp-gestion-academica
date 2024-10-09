package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Aula;

@RequestScoped
@Named("aulaConverter")
public class AulaConverter extends AbstractEntityConverter<Aula>{
}
