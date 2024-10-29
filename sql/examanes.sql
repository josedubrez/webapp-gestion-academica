drop table if exists examenes;

create table examenes (
    id serial,
    id_plan_curso integer,
    fecha integer,
	puntaje integer,
    tipo_examen varchar(1),
    forma_examen varchar(2),
	constraint pk_examanes
	primary key (id),
	constraint examenes_tipo_examen_check
	check (tipo_examen in ('P', 'F')),
	constraint examenes_forma_examen_check
	check (forma_examen in ('PO', 'SO', 'EX'))
);