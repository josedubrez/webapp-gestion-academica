package org.utic.webapp.gestion.entities;

import java.util.Objects;

public abstract class AbstractEntity<T extends EntityWithId> implements EntityWithId{
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T t = (T) o;
        return Objects.equals(getId(), t.getId());
    }
}
