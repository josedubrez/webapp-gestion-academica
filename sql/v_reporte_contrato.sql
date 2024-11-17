drop view if exists v_reporte_contrato;

create view v_reporte_contrato
as
select
	row_number() over() as id,
	ss.*
from (
	select
		d.id as id_docente,
	    'Entre las partes, Universidad San Isidro, y ' ||
	     d.nombre || ' ' || d.apellido || ',' || 'identificado/a con la cédula de identidad ' || d.nro_cedula || ',' ||
	    ' se acuerda la prestación de servicios docentes en las asignaturas designadas.' || CHR(10) || CHR(10) ||
	    'El contrato inicia el ' || to_char(cd.fecha_inicio,'dd/mm/yyyy') || ' y finaliza el ' || to_char(cd.fecha_fin,'dd/mm/yyyy') || '.' || CHR(10) ||
	    'Para mayor información, puede ser contactado/a al correo ' || email ||
	    ' o al teléfono ' || telefono || '.' || CHR(10) ||
	    'El/la docente está registrado/a con el ID interno ' || d.id::varchar || '.' AS desc_contrato
	from docentes d
	inner join contratos_docentes cd on (cd.id_docente = d.id)
	) ss;