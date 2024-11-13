ALTER TABLE mallas ADD CONSTRAINT uq_malla_carrera unique (id_carrera,anio);
ALTER TABLE planes_cursos  ADD CONSTRAINT uq_plan_materia unique (id_malla_det,id_sede,id_turno);

CREATE OR REPLACE FUNCTION public.f_tr_ins_planes_curso()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_anio integer;
	dummy integer = 0;
begin
	select distinct m.anio
		into v_anio
	from mallas m, mallas_det md
	where m.id = md.id_malla
	and m.aprobado = true
	and md.id = new.id_malla_det;

	if v_anio is null then
	 raise exception 'Malla seleccionada aún no está aprobada. Favor verificar! ';
	elsif (v_anio < EXTRACT(YEAR FROM new.fecha_inicio) or v_anio < EXTRACT(YEAR FROM new.fecha_fin))  then
	  raise exception 'El año del plan de curso no corresponde a la malla. Favor verificar! ';
	end if;

	if (new.fecha_exa_parcial <= new.fecha_inicio or new.fecha_exa_parcial >= new.fecha_fin) then
	  raise exception 'Fecha de examen parcial debe estar en el rango de fecha de la materia. Favor verificar!  ';
	end if;

	if (new.fecha_exa_final <= new.fecha_exa_parcial or new.fecha_exa_final > new.fecha_fin) then
	  raise exception 'Fecha de examen final debe ser mayor a fecha de examen parcial y menor a fecha final de materia. Favor verificar!  ';
	end if;

		select count(*)
			into dummy
		from mallas m
		inner join mallas_det md
		on m.id = md.id_malla
		inner join planes_cursos pc
		on md.id = pc.id_malla_det
		where pc.fecha_exa_parcial = new.fecha_exa_parcial
		and pc.id_sede = new.id_sede
		and pc.id_turno = new.id_turno;

	if dummy <> 0 then
	raise exception 'Fecha de examen ya definido en otra materia de la malla. Favor verificar!';
	end if;

 return new;

end;
$function$
;
create trigger tr_ins_planes_curso after
insert
    on
    public.planes_cursos  for each row execute procedure f_tr_ins_planes_curso();

CCREATE OR REPLACE FUNCTION public.f_tr_upd_planes_curso()
  RETURNS trigger
  LANGUAGE plpgsql
 AS $function$
 declare
 	v_anio integer;
 	dummy integer = 0;
 begin
 	select distinct m.anio
 		into v_anio
 	from mallas m, mallas_det md
 	where m.id = md.id_malla
 	and md.id = new.id_malla_det;
 	--raise exception 'El año del plan de curso no corresponde a la malla. Favor verificar! ', new.fecha_incio;
 	if (v_anio < EXTRACT(YEAR FROM new.fecha_inicio) or v_anio < EXTRACT(YEAR FROM new.fecha_fin))  then
 	  raise exception 'El año del plan de curso no corresponde a la malla. Favor verificar! ';
 	end if;

 	if (new.fecha_exa_parcial <= new.fecha_inicio or new.fecha_exa_parcial >= new.fecha_fin) then
 	  raise exception 'Fecha de examen parcial debe estar en el rango de fecha de la materia. Favor verificar!  ';
 	end if;

 	if (new.fecha_exa_final <= new.fecha_exa_parcial or new.fecha_exa_final > new.fecha_fin) then
 	  raise exception 'Fecha de examen final debe ser mayor a fecha de examen parcial y menor a fecha final de materia. Favor verificar!  ';
 	end if;

 		if old.aprobado = true then
 		 raise exception 'Plan de Curso aprobado. No puede realizar modificaciones!';
 		end if;

  return new;

 end;
 $function$
 ;

create trigger tr_upd_planes_curso after
update
    on
    public.planes_cursos  for each row execute procedure f_tr_upd_planes_curso()