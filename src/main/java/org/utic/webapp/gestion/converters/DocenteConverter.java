package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Docente;

@RequestScoped
@Named("docenteConverter")
public class DocenteConverter extends AbstractEntityConverter<Docente>{
}
