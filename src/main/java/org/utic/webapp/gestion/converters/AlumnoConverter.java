package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Alumno;

@RequestScoped
@Named("alumnoConverter")
public class AlumnoConverter extends AbstractEntityConverter<Alumno>{
}
