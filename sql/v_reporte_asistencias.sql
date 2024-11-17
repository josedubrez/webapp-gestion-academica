drop view if exists v_reporte_asistencias;

create or replace view v_reporte_asistencias
as 
select 
	row_number() over () as id,
	ss.*
from 
	( 
	select 
		c.fecha,
        a.id as id_alumno,
        d.id as id_docente,
        pc.id as id_plan_curso,
        to_char(c.fecha, 'dd/mm/yyyy') as desc_fecha,
        ma.descripcion as desc_materia,
        '(' || a.nro_cedula || ') ' || a.apellido || ', ' || a.nombre as desc_alumno,
        '(' || d.nro_cedula || ') ' || d.apellido || ', ' || d.nombre as desc_docente,
        case when aa.presente then 'SI' else 'NO' end as desc_presente,
        coalesce(ja.motivo, '') as desc_justificativo
    from mallas m
        join carreras ca on ca.id = m.id_carrera
        join mallas_det md on m.id = md.id_malla
        join materias ma on ma.id = md.id_materia
        join planes_cursos pc on pc.id_malla_det = md.id
		join docentes d on pc.id_docente = d.id
        join clases c on c.id_plan_curso = pc.id
        join asistencias_alumnos aa on aa.id_clase = c.id
        join alumnos a on aa.id_alumno = a.id
        left join justificativos_alumnos ja on aa.id_justificativo = ja.id
    order by c.fecha, a.apellido, a.nombre
	) ss;