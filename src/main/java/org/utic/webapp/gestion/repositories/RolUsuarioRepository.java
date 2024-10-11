package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class RolUsuarioRepository extends AbstractCrudRepository<RolUsuario>{
    @Override
    protected String select() {
        return "SELECT r FROM RolUsuario r "+
                "LEFT OUTER JOIN FETCH r.usuario "+
                "LEFT OUTER JOIN FETCH r.rol ";
    }

    public List<RolUsuario> getAllByUsuario(Usuario usuario){
        return super.em.createQuery(select() + " WHERE r.usuario.id = :id_usuario " + "ORDER BY r.id DESC", super.entityClass)
                .setParameter("id_usuario", usuario.getId())
                .getResultList();
    }
}
