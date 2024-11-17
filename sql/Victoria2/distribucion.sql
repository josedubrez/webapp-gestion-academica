CREATE OR REPLACE FUNCTION public.f_tr_upd_distribuciones_escalas()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	dummy integer;
begin

		select distinct 1
		into dummy
		from planes_cursos pc
		where pc.aprobado = true
		and (pc.id  = new.id_plan_curso or pc.id  = old.id_plan_curso) ;

		if dummy = 1 then
		  	raise exception 'Plan de Curso ya aprobado. No puede realizar modificaciones! ';
		end if;

 return new;

end;
$function$

;
create trigger tr_ins_distribuciones_escalas after
delete on
    public.distribuciones_escalas  for each row execute procedure f_tr_upd_distribuciones_escalas();

create trigger tr_del_distribuciones_escalas after
delete on
    public.distribuciones_escalas  for each row execute procedure f_tr_upd_distribuciones_escalas();

create trigger tr_upd_distribuciones_escalas after
update on
    public.distribuciones_escalas  for each row execute procedure f_tr_upd_distribuciones_escalas();