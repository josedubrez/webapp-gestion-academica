CREATE TABLE public.requisitos(
	id serial,
	descripcion varchar(200),
	constraint pk_requisitos primary key(id)
);

alter table requisitos_inscripcion_alumnos drop constraint if exists fk_requisitos_inscripcion_det_req_ins;
ALTER TABLE public.requisitos_inscripcion_alumnos ADD CONSTRAINT fk_requisitos_inscripcion_requisitos FOREIGN KEY (id_requisito) REFERENCES public.requisitos(id);
