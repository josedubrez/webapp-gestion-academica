package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.ViewPermisoUsuario;
import org.utic.webapp.gestion.utils.Cripto;

@RequestScoped
public class ViewPermisoUsuarioRepository extends AbstractViewRepository<ViewPermisoUsuario>{
    @Override
    protected String select() {
        return "SELECT r FROM ViewPermisoUsuario r "+
                "LEFT OUTER JOIN FETCH r.docente ";
    }

    public ViewPermisoUsuario getByUsernameAndPassword(String username, String password){
        ViewPermisoUsuario result;
        try{
             result =  super.em.createQuery(select() + " WHERE r.username = :username AND r.password = :password", super.entityClass)
                        .setParameter("username", username)
                        .setParameter("password", Cripto.generateHashMD5(password))
                        .getSingleResult();
        }catch (Exception e){
            result = null;
        }
        return result;
    }
}
