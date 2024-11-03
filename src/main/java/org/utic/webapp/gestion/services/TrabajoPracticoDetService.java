package org.utic.webapp.gestion.services;

import jakarta.ejb.Local;
import org.utic.webapp.gestion.entities.TrabajoPractico;
import org.utic.webapp.gestion.entities.TrabajoPracticoDet;

import java.util.List;

@Local
public interface TrabajoPracticoDetService extends CrudService<TrabajoPracticoDet>{
    List<TrabajoPracticoDet> getAllByTrabajoPractico(TrabajoPractico trabajoPractico);
}