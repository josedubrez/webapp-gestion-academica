package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.MallaDet;

@RequestScoped
@Named("mallaDetConverter")
public class MallaDetConverter extends AbstractEntityConverter<MallaDet>{
}
