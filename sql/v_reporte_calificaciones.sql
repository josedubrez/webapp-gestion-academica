drop view if exists v_reporte_calificaciones;

create or replace view v_reporte_calificaciones
as
select
	row_number() over () as id,
	ss.*
from
	(
	select
        m.id as id_malla,
        md.nro_semestre as nro_semestre,
        md.id as id_malla_det,
        s.id as id_sede,
        t.id as id_turno,
        d.id as id_docente,
        a.id as id_alumno,
        m.descripcion as desc_malla,
        ma.descripcion as desc_materia,
        s.descripcion as desc_sede,
        t.descripcion as desc_turno,
        '(' || d.nro_cedula || ') ' || d.apellido || ', ' || d.nombre as desc_docente,
        '(' || a.nro_cedula || ') ' || a.apellido || ', ' || a.nombre as desc_alumno,
        c.calificacion::char || (case when c.felicitado then 'F' else '' end) as desc_calificacion
    from mallas m
        join carreras ca on ca.id = m.id_carrera
        join mallas_det md on m.id = md.id_malla
        join materias ma on ma.id = md.id_materia
        join planes_cursos pc on pc.id_malla_det = md.id
		join docentes d on pc.id_docente = d.id
		join sedes s on pc.id_sede = s.id
		join turnos t on pc.id_turno = t.id
		join calificaciones c on c.id_plan_curso = pc.id
		join alumnos a on c.id_alumno = a.id
    order by md.nro_semestre, ma.descripcion, s.descripcion, t.descripcion, a.apellido, a.nombre
	) ss;