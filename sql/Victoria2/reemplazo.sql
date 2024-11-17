CREATE OR REPLACE FUNCTION public.f_tr_ins_reemplazo_docente()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_horario integer ;
	v_docente integer;
begin

select distinct 1
into v_docente
from planes_cursos_horarios pch
where pch.id_plan_curso = new.id_plan_curso
and exists (select 1
			from planes_cursos_horarios pch2
			inner join planes_cursos pc2 on (pc2.id = pch2.id_plan_curso)
			where pc2.id_docente = new.id_docente
			and pch2.id_dia_semana = pch.id_dia_semana
			and (
				(pch2.horario_desde between pch.horario_desde and pch.horario_hasta) or
				(pch2.horario_hasta between pch.horario_desde and pch.horario_hasta) or
				(pch.horario_desde between pch2.horario_desde and pch2.horario_hasta) or
				(pch.horario_desde between pch2.horario_desde and pch2.horario_hasta)
				)
			)
and exists (select 1
			from
				(select generate_series(new.fecha_ini::date, new.fecha_fin::date, '1 day'::interval) as fecha) ss
			where extract(dow from ss.fecha) = pch.id_dia_semana
			);
	if v_docente is not null then
		raise exception 'Docente ya cuenta con clase asignada en fecha y hora seleccionada. Favor verificar!.';
	end if;

 return new;

end;
$function$
;

create trigger tr_ins_reemplazo_docente after
insert
    on
    public.reemplazos for each row execute procedure f_tr_ins_reemplazo_docente();
  drop trigger tr_update_reemplazo_docente on reemplazos
   create trigger tr_update_reemplazo_docente after
update
    on
    public.reemplazos for each row execute procedure f_tr_ins_reemplazo_docente();