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