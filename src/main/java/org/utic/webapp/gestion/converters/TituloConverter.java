package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Titulo;

@RequestScoped
@Named("tituloConverter")
public class TituloConverter extends AbstractEntityConverter<Titulo>{
}
