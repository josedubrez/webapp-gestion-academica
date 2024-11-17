alter table planes_cursos_horarios drop column if exists hora_desde;
alter table planes_cursos_horarios drop column if exists hora_hasta;

alter table clases drop column if exists fecha_hora_desde;
alter table clases drop column if exists fecha_hora_hasta;

alter table clases add column fecha date default current_date;
alter table clases add column id_aula integer;
alter table clases add column horario_desde time;
alter table clases add column horario_hasta time;

alter table clases
add constraint fk_clases_aulas
foreign key (id_aula)
references aulas (id);

alter table asistencias_alumnos
drop constraint if exists fk_asistencias_alumnos_clases;

alter table asistencias_alumnos
add constraint fk_asistencias_alumnos_clases
foreign key (id_clase)
references clases (id)
on delete cascade;