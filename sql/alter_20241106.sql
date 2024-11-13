drop table if exists calificaciones;

create table calificaciones (
    id serial,
    id_alumno integer,
    id_plan_curso integer,
    fecha date,
    puntaje_trabajos_clases integer,
    puntaje_trabajo_practico integer,
    puntaje_examen_parcial integer,
    puntaje_examen_final integer,
    calificacion numeric(5, 2),
    felicitado boolean,
    constraint pk_calificaciones primary key (id),
    constraint fk_calificaciones_alumnos foreign key (id_alumno) references alumnos(id),
    constraint fk_calificaciones_planes_cursos foreign key (id_plan_curso) references planes_cursos(id)
);