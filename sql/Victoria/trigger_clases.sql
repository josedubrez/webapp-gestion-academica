--funcion del trigger
create or replace function f_insertar_asistencias()
returns trigger as $$
begin
    insert into asistencias_alumnos (id_alumno, id_clase, presente)
    select im.id_alumno, new.id, false
    from inscripciones_mallas im
	inner join mallas m on (m.id = im.id_malla)
	inner join mallas_det md on (md.id_malla = m.id and im.nro_semestre = md.nro_semestre)
    inner join planes_cursos pc on (pc.id_malla_det = md.id and pc.id_sede = im.id_sede and pc.id_turno = im.id_turno)
    where pc.id = new.id_plan_curso;

    return new;
end;
$$ language plpgsql;

--definicion del trigger
create trigger tr_a_clases
after insert on clases
for each row
execute function f_insertar_asistencias();