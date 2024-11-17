drop view if exists v_calificaciones_pendientes;

create view v_calificaciones_pendientes as
select
    ss.id,
    ss.id_malla,
    ss.id_plan_curso,
    ss.id_docente,
    ss.id_alumno,
    ss.puntaje_trabajos_clases,
    ss.puntaje_trabajo_practico,
    ss.puntaje_examen_parcial,
    ss.puntaje_examen_final,
    case
        when (ss.puntaje_trabajos_clases + ss.puntaje_trabajo_practico + ss.puntaje_examen_parcial + ss.puntaje_examen_final) >= ec.puntaje5 then 5
        when (ss.puntaje_trabajos_clases + ss.puntaje_trabajo_practico + ss.puntaje_examen_parcial + ss.puntaje_examen_final) >= ec.puntaje4 then 4
        when (ss.puntaje_trabajos_clases + ss.puntaje_trabajo_practico + ss.puntaje_examen_parcial + ss.puntaje_examen_final) >= ec.puntaje3 then 3
        when (ss.puntaje_trabajos_clases + ss.puntaje_trabajo_practico + ss.puntaje_examen_parcial + ss.puntaje_examen_final) >= ec.puntaje2 then 2
        else 1
    end as calificacion,
    case
        when (ss.puntaje_trabajos_clases + ss.puntaje_trabajo_practico + ss.puntaje_examen_parcial + ss.puntaje_examen_final) >= ec.puntaje5f then true
        else false
    end as felicitado
from (
    select
    	row_number() over() as id,
        m.id as id_malla,
        pc.id as id_plan_curso,
        d.id as id_docente,
        im.id_alumno,
        coalesce((select sum(tcd.puntaje)
                  from trabajos_clases_det tcd
                  join trabajos_clases tc on tc.id = tcd.id_trabajo_clase
                  join clases c on c.id = tc.id_clase
                  where tcd.id_alumno = im.id_alumno and c.id_plan_curso = pc.id and tc.es_acumulativo = true), 0) as puntaje_trabajos_clases,
        coalesce((select sum(tpd.puntaje)
                  from trabajos_practicos_det tpd
                  join trabajos_practicos tp on tp.id = tpd.id_trabajo_practico
                  where tpd.id_alumno = im.id_alumno and tp.id_plan_curso = pc.id), 0) as puntaje_trabajo_practico,
        coalesce((select sum(ed.puntaje)
                  from examenes_det ed
                  join examenes e on e.id = ed.id_examen
                  where ed.id_alumno = im.id_alumno and e.id_plan_curso = pc.id and e.tipo_examen = 'P'), 0) as puntaje_examen_parcial,
        coalesce((select sum(ed.puntaje)
                  from examenes_det ed
                  join examenes e on e.id = ed.id_examen
                  where ed.id_alumno = im.id_alumno and e.id_plan_curso = pc.id and e.tipo_examen = 'F'), 0) as puntaje_examen_final
    from
        inscripciones_mallas im
        join mallas m on m.id = im.id_malla
        join mallas_det md on md.id_malla = m.id and im.nro_semestre = md.nro_semestre
        join planes_cursos pc on pc.id_malla_det = md.id and pc.id_sede = im.id_sede and pc.id_turno = im.id_turno
        join docentes d on pc.id_docente = d.id
) ss
join escalas_calificaciones ec on ec.id_malla = ss.id_malla
where not exists (
    select 1
    from calificaciones c
    where c.id_plan_curso = ss.id_plan_curso and c.id_alumno = ss.id_alumno
);