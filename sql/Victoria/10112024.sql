CREATE OR REPLACE FUNCTION public.f_tr_ins_distribuciones_escalas()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_calificacion integer = 0;
begin
	select ec.puntaje5f
	into v_calificacion
	from  planes_cursos pc
	inner join mallas_det md
	on md.id = pc.id_malla_det
	left join escalas_calificaciones ec
	on ec.id_malla = md.id_malla
	where pc.id = new.id_plan_curso;

	if (v_calificacion <> sum(new.puntaje_trabajos_clases +new.puntaje_trabajo_practico+new.puntaje_examen_parcial+new.puntaje_examen_final)) then
	  raise exception 'La suma de las calificaciones debe ser igual %', v_calificacion;
	end if;
 return new;

end;
$function$
;


create trigger tr_ins_distribuciones_escalas after
insert
    on
    public.distribuciones_escalas for each row execute procedure f_tr_ins_distribuciones_escalas();

    create trigger tr_upda_distribuciones_escalas after
    update
        on
        public.distribuciones_escalas for each row execute procedure f_tr_ins_distribuciones_escalas();


        -- DROP FUNCTION public.f_tr_ins_distribuciones_escalas();

        CREATE OR REPLACE FUNCTION public.f_tr_ins_escalas_calificaciones()
         RETURNS trigger
         LANGUAGE plpgsql
        AS $function$
        declare
        	v_calificacion integer;
        begin
        	select distinct 1
        	into v_calificacion
        	into v_calificacion
        	from  escalas_calificaciones ec
        	on ec.id_malla = new.id;

        	if (v_calificacion is null) then
        	  raise exception 'No existe registro de escala de calificaciones. Favor verificar';
        	end if;
         return new;

        end;
        $function$
        ;

CREATE OR REPLACE FUNCTION public.f_tr_ins_escalas_calificaciones()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_calificacion integer;
begin
	select distinct 1
	into v_calificacion
	from  escalas_calificaciones ec
	where ec.id_malla = new.id;

	if (v_calificacion is null) then
	  raise exception 'No existe registro de escala de calificaciones. Favor verificar';
	end if;
 return new;

end;
$function$
;



   create trigger tr_ins_escalas_calificaciones before --or after
update
    on
    public.escalas_calificaciones for each row execute procedure f_tr_ins_escalas_calificaciones();



    CREATE OR REPLACE FUNCTION public.f_tr_upd_mallas()
     RETURNS trigger
     LANGUAGE plpgsql
    AS $function$
    declare
    	v_calificacion integer;
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

    		/*select sum(md.horas_catedra)
    			into v_horas_catedra
    		from mallas m, mallas_det md
    		where m.id = md.id_malla
    		and m.id = old.id;
    	 if v_horas_catedra <= 600 then
    	  raise exception 'Las horas catedras de la malla debe ser mayor a 600. Favor verificar! ';
    	 end if;*/
    	end if;

     return new;
    end;
    $function$
    ;

    create trigger tr_upd_mallas before --or after
    update
        on
        public.mallas for each row execute procedure f_tr_upd_mallas();
