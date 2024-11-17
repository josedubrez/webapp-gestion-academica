create or replace function f_atr_ins__trabajos_clases()
returns trigger as $$
begin
	insert into trabajos_clases_det (id_alumno, id_trabajo_clase, puntaje)
    select im.id_alumno, new.id, 0
    from inscripciones_mallas im
	inner join mallas m on (m.id = im.id_malla)
	inner join mallas_det md on (md.id_malla = m.id and im.nro_semestre = md.nro_semestre)
    inner join planes_cursos pc on (pc.id_malla_det = md.id and pc.id_sede = im.id_sede and pc.id_turno = im.id_turno)
	inner join clases c on (c.id_plan_curso = pc.id)
    where c.id = new.id_clase;

    return new;
end;
$$ language plpgsql;


create trigger atr_ins__trabajos_clases
after insert on trabajos_clases
for each row
execute function f_atr_ins__trabajos_clases();