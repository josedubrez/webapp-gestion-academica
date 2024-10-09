package org.utic.webapp.gestion.converters;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import org.utic.webapp.gestion.entities.Carrera;
import org.utic.webapp.gestion.entities.EntityWithId;
import org.utic.webapp.gestion.services.CrudService;

public abstract class AbstractEntityConverter<T extends EntityWithId> implements Converter<T> {

    @Inject
    private CrudService<T> servicio;

    @Override
    public T getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return servicio.getById(Long.valueOf(id));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, T t) {
        if (t == null) {
            return "";
        }
        return String.valueOf(t.getId());
    }

}
