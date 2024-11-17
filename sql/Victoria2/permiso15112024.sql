
CREATE OR REPLACE FUNCTION public.f_tr_ins_permiso_docente()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_reemplazo integer;
begin
	select distinct 1
	into v_reemplazo
	from reemplazos r,
		planes_cursos pc
	where r.id_plan_curso = pc.id
	and pc.id_docente =  new.id_docente
	and cast(to_char(r.fecha_ini,'yyyy-mm-dd')as date) = cast(to_char(new.fecha_ini,'yyyy-mm-dd') as date)
	and cast(to_char(r.fecha_fin,'yyyy-mm-dd')as date) = cast(to_char(new.fecha_fin,'yyyy-mm-dd') as date);

	if v_reemplazo is null then
		raise exception 'Primero debe registrar reemplazo docente!';
	end if;
 return new;

end;
$function$
;


create trigger tr_ins_permiso_docente after
insert on permisos_docentes for each row execute procedure f_tr_ins_permiso_docente();