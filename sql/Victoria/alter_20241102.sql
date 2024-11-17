alter table trabajos_practicos_det drop constraint if exists fk_trabajos_practicos_det_trabajos_practicos;

alter table trabajos_practicos_det
add constraint fk_trabajos_practicos_det_trabajos_practicos
foreign key (id_trabajo_practico)
references trabajos_practicos (id)
on delete cascade;

alter table examenes_det drop constraint if exists fk_examenes_det_examenes;

alter table examenes_det
add constraint fk_examenes_det_examenes
foreign key (id_examen)
references examenes (id)
on delete cascade;

alter table trabajos_clases rename column puntaje_posible to puntaje;
alter table trabajos_clases_det rename column puntaje_logrado to puntaje;
alter table trabajos_clases drop column if exists indicaciones;
alter table trabajos_clases add column if not exists titulo varchar(255);

alter table trabajos_clases_det drop constraint if exists fk_trabajos_clases_det_trabajos_clases;

alter table trabajos_clases_det
add constraint fk_trabajos_clases_det_trabajos_clases
foreign key (id_trabajo_clase)
references trabajos_clases (id)
on delete cascade;