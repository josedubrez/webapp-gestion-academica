drop view if exists v_reporte_justificativos;

create view v_reporte_justificativos
as
select
	row_number() over() as id,
	ss.*
from (
	select *
	from (
		select
			jd.fecha as fecha,
			d.id as id_docente,
			to_char(jd.fecha,'dd/mm/yyyy') as desc_fecha,
			'(' || d.nro_cedula || ') ' || d.apellido || ', ' || d.nombre as desc_docente,
			'JUSTIFICATIVO: ' || jd.motivo as desc_motivo,
			jd.dir_archivo as dir_archivo
		from justificativos_docentes jd
		inner join docentes d on (d.id = jd.id_docente)
		union all
		select
			pd.fecha_ini as fecha,
			d.id as id_docente,
			to_char(pd.fecha_ini,'dd/mm/yyyy') as desc_fecha,
			'(' || d.nro_cedula || ') ' || d.apellido || ', ' || d.nombre as desc_docente,
			'PERMISO: ' || pd.motivo as desc_motivo,
			pd.dir_archivo as dir_archivo
		from permisos_docentes pd
		inner join docentes d on (d.id = pd.id_docente)
		) sss
		order by sss.fecha
	) ss;