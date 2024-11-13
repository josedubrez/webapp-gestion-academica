CREATE OR REPLACE FUNCTION public.f_tr_ins_inscripcion()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_requisitos integer;
	v_req_presento integer;
v_alumno integer;
begin
	select count(*)
	into v_alumno
	from mallas m
	where m.id = new.id_malla
	and m.cupos <= (select count(*)
					from inscripciones_mallas im
					where im.id_malla = new.id_malla)
	;
	if v_alumno <> 0 then
		raise exception 'Cantidad de cupos lleno! %',v_alumno;
	end if;


	if new.nro_semestre = 1 then
			select count(*)
			into v_requisitos
			from requisitos_inscripcion ri
			where ri.id_malla = new.id_malla;

			if v_requisitos > 0 then
					select count(*)
					into v_req_presento
					from requisitos_inscripcion_alumnos ra
					inner join requisitos_inscripcion ri on (ra.id_requisito = ri.id_requisito)
					where ra.id_alumno = new.id_alumno
					and ri.id_malla = new.id_malla
					and ra.entregado = true;

				if v_requisitos > v_req_presento then
					raise exception 'Falta requisitos de inscripción a presentar. Favor Verificar! ';
				end if;
			end if;
	end if;
 return new;

end;
$function$
;