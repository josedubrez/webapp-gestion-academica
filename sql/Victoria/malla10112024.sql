
CREATE OR REPLACE FUNCTION public.f_tr_upd_mallas()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_calificacion integer;
	v_horas_catedra integer;
v_semestre integer;
	dummy integer = 0;
begin
	if new.aprobado = true then
		 select distinct 1
		into v_calificacion
		from  escalas_calificaciones ec
		where ec.id_malla = new.id;

	if (v_calificacion is null) then
	  raise exception 'No existe registro de escala de calificaciones. Favor verificar';
	end if;

		if (old.aprobado = true and new.aprobado = false) then
				select distinct 1
					into dummy
				from planes_cursos pc , mallas_det md
				where pc.id_malla_det = md.id
				and pc.aprobado = true
				and md.id_malla = old.id;
			if dummy <> 0 then
			raise exception 'Ya está aprobado un plan de curso con la malla % ', old.descripcion;
		end if;
	end if;

		select count(*)
			into v_horas_catedra
		from
			(
			select sum(md.horas_catedra)
				from mallas m, mallas_det md
				where m.id = md.id_malla
				and m.id = old.id
				group by md.nro_semestre
				having sum(md.horas_catedra) not between 300 and 700
			) ss;
		 if v_horas_catedra <> 0 then
		  raise exception 'Las horas catedras de la malla por semestre debe estar entre 300 y 700. Favor verificar! ';
		 end if;

			select count(distinct md.nro_semestre)
			into v_semestre
			from mallas m, mallas_det md
			where m.id = md.id_malla
			and m.id = old.id;

		if v_semestre <> old.cantidad_semestres then
		  raise exception 'Cantidad de semestres registradas son menores al de la malla. Favor verificar! ';
		 end if;

	end if;

 return new;
end;
$function$
;

