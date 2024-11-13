drop view if exists v_reporte_mallas;

create view v_reporte_mallas
as 
select 
	row_number() over() as id,
	ss.*
from (
	select 
	    c.descripcion || ' ' || m.anio::varchar as desc_malla,
	    'SEMESTRE ' || md.nro_semestre::varchar as nro_semestre,
	    md.horas_catedra::varchar as horas_catedra,
	    ma.sigla,
	    ma.descripcion as desc_materia,
	    coalesce(mac.descripcion,'') as desc_materia_correlativa
	from 
		mallas m
	    inner join carreras c on c.id = m.id_carrera
	    inner join mallas_det md on m.id = md.id_malla
	    inner join materias ma on ma.id = md.id_materia
	    left join mallas_det mdc on mdc.id = md.id_malla_det_ref
	    left join materias mac on mac.id = mdc.id_materia
	 order by
		md.nro_semestre, ma.descripcion
	) ss;