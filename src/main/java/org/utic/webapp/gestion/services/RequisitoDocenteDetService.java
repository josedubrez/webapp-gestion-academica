package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;

import org.utic.webapp.gestion.entities.*;

import java.util.List;

@Local
public interface RequisitoDocenteDetService extends CrudService<RequisitoDocenteDet>{
    List<RequisitoDocenteDet> getAllByPostulante(Postulante postulante);
    List<RequisitoDocente> getRequisitosDocentesAll();
}
