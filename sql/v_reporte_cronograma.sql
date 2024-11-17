drop view if exists v_reporte_cronograma;

create or replace view v_reporte_cronograma
as
select
	row_number() over () as id,
	ss.*
from
	(
	select
        m.id as id_malla,
        md.nro_semestre as nro_semestre,
        pc.id as id_plan_curso,
        d.id as id_docente,
        m.descripcion as desc_malla,
        pc.id::varchar as desc_plan_curso,
        ma.descripcion as desc_materia,
        '(' || d.nro_cedula || ') ' || d.apellido || ', ' || d.nombre as desc_docente,
        s.descripcion as desc_sede,
        t.descripcion as desc_turno,
        to_char(pc.fecha_inicio, 'dd/mm/yyyy') as desc_fecha_inicio,
        to_char(pc.fecha_fin, 'dd/mm/yyyy') as desc_fecha_fin,
        to_char(pc.fecha_exa_parcial, 'dd/mm/yyyy') as desc_fecha_exa_parcial,
        to_char(pc.fecha_exa_final, 'dd/mm/yyyy') as desc_fecha_exa_final,
        ds.dia as desc_dia_semana,
        a.numero as desc_aula,
        to_char(pch.horario_desde, 'hh24:mi') as horario_desde,
        to_char(pch.horario_hasta, 'hh24:mi') as horario_hasta
    from mallas m
        join carreras ca on ca.id = m.id_carrera
        join mallas_det md on m.id = md.id_malla
        join materias ma on ma.id = md.id_materia
        join planes_cursos pc on pc.id_malla_det = md.id
		join docentes d on pc.id_docente = d.id
		join sedes s on pc.id_sede = s.id
		join turnos t on pc.id_turno = t.id
		join planes_cursos_horarios pch on pch.id_plan_curso = pc.id
		join dias_semana ds on pch.id_dia_semana = ds.id
		join aulas a on pch.id_aula = a.id
    order by s.descripcion, t.descripcion, ma.descripcion, pch.id_dia_semana, pch.horario_desde
	) ss;