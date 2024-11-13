CREATE OR REPLACE FUNCTION public.f_tr_upd__aprobado__planes_cursos()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_escala_count integer;
begin
	--verificar que exista al menos un registro en distribuciones_escalas para el plan de curso
	if new.aprobado = true then
		    select count(*)
			into v_escala_count
		    from distribuciones_escalas
		    where id_plan_curso = new.id;

		    if v_escala_count = 0 then
		        raise exception 'No existe una distribucion de puntajes para el plan de curso con ID: %', new.id;
		    end if;
	end if;
    if new.aprobado = true then
        -- insertar examen parcial
        insert into examenes (id_plan_curso, fecha, tipo_examen, forma_examen, puntaje)
        values (
            new.id,
            new.fecha_exa_parcial,
            'P',
            'PO',
            (select puntaje_examen_parcial from distribuciones_escalas where id_plan_curso = new.id limit 1)
        );

        -- insertar examen final
        insert into examenes (id_plan_curso, fecha, tipo_examen, forma_examen, puntaje)
        values (
            new.id,
            new.fecha_exa_final,
            'F',
            'PO',
            (select puntaje_examen_final from distribuciones_escalas where id_plan_curso = new.id limit 1)
        );

		-- insertar trabajo practico
        insert into trabajos_practicos (id_plan_curso, titulo, puntaje)
        values (
            new.id,
			'Trabajo Practico',
            (select puntaje_trabajo_practico from distribuciones_escalas where id_plan_curso = new.id limit 1)
        );

    elsif new.aprobado = false then
        delete from examenes where id_plan_curso = new.id;
        delete from trabajos_practicos where id_plan_curso = new.id;
    end if;

    return new;
end;
$function$
;