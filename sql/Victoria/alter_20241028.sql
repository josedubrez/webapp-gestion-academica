drop table if exists distribuciones_escalas;

create table distribuciones_escalas (
	id serial,
	id_plan_curso integer,
	puntaje_trabajos_clases integer,
	puntaje_trabajo_practico integer,
	puntaje_examen_parcial integer,
	puntaje_examen_final integer,
	constraint pk_distribuciones_escalas
	primary key (id),
	constraint fk_distribuciones_escalas_planes_cursos
	foreign key (id_plan_curso)
	references planes_cursos (id),
	constraint uk_distribuciones_escalas_plan_curso
	unique (id_plan_curso)
);

alter table examenes alter column tipo_examen set default 'P';
alter table examenes alter column forma_examen set default 'PO';

alter table escalas_calificaciones add constraint uk_mallas unique (id_malla);

alter table examenes drop constraint if exists examenes_forma_examen_check;
alter table examenes add constraint examenes_forma_examen_check check (forma_examen in ('PO', 'SO', 'EX'));