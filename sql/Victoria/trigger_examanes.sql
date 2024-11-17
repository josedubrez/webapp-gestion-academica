create or replace function f_tr_ins__examanes()
returns trigger as $$
declare
	v_escala_count integer;
begin
	--verificar que exista al menos un registro en distribuciones_escalas para el plan de curso
    select count(*)
	into v_escala_count
    from distribuciones_escalas
    where id_plan_curso = new.id_plan_curso;

    if v_escala_count = 0 then
        raise exception 'No existe una distribucion de puntajes para el plan de curso con ID: %', new.id;
    end if;

    -- verificar si el puntaje es null
    if new.puntaje is null then
        -- si el tipo de examen es parcial ('p'), tomar puntaje_examen_parcial de distribuciones_escalas
        if new.tipo_examen = 'P' then
            select puntaje_examen_parcial into new.puntaje
            from distribuciones_escalas
            where id_plan_curso = new.id_plan_curso
			limit 1;

        -- si el tipo de examen es final ('f'), tomar puntaje_examen_final de distribuciones_escalas
        elsif new.tipo_examen = 'F' then
            select puntaje_examen_final into new.puntaje
            from distribuciones_escalas
            where id_plan_curso = new.id_plan_curso
			limit 1;
        end if;
    end if;

    return new;
end;
$$ language plpgsql;


create trigger tr_ins__examanes
before insert on examenes
for each row
execute function f_tr_ins__examanes();