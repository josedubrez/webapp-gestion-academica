CREATE OR REPLACE FUNCTION public.f_tr_ins_inscripcion()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_requisitos integer;
	v_req_presento integer;
begin
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


create trigger tr_ins_ins_inscripcion after
insert on inscripciones_mallas for each row execute procedure f_tr_ins_inscripcion()
---

create trigger tr_upd_ins_inscripcion after
update on inscripciones_mallas for each row execute procedure f_tr_ins_inscripcion()