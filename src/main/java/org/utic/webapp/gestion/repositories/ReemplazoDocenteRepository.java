package org.utic.webapp.gestion.repositories;

import jakarta.enterprise.context.RequestScoped;
import org.utic.webapp.gestion.entities.*;

import java.util.List;

@RequestScoped
public class ReemplazoDocenteRepository extends AbstractCrudRepository<ReemplazoDocente>{
    @Override
    protected String select() {
        return "SELECT r FROM ReemplazoDocente r " +
               "LEFT OUTER JOIN FETCH r.planCurso "+
                "LEFT OUTER JOIN FETCH r.docente "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet "+
               "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.malla.carrera "+
                "LEFT OUTER JOIN FETCH r.planCurso.mallaDet.materia "+
                "LEFT OUTER JOIN FETCH r.planCurso.turno "+
                "LEFT OUTER JOIN FETCH r.planCurso.docente "+
                "LEFT OUTER JOIN FETCH r.planCurso.sede ";
    }


}
