package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Temario;

@RequestScoped
@Named("temarioConverter")
public class TemarioConverter extends AbstractEntityConverter<Temario>{
}
