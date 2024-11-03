package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Requisito;

@RequestScoped
@Named("requisitoConverter")
public class RequisitoConverter extends AbstractEntityConverter<Requisito>{
}
