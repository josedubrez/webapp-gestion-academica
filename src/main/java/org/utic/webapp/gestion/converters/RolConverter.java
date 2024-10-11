package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Rol;

@RequestScoped
@Named("rolConverter")
public class RolConverter extends AbstractEntityConverter<Rol>{
}
