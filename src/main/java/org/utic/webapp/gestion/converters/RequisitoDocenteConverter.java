package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.RequisitoDocente;

@RequestScoped
@Named("requisitoDocenteConverter")
public class RequisitoDocenteConverter extends AbstractEntityConverter<RequisitoDocente>{
}
