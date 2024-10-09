package org.utic.webapp.gestion.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.utic.webapp.gestion.entities.Materia;

@RequestScoped
@Named("materiaConverter")
public class MateriaConverter extends AbstractEntityConverter<Materia>{
}
