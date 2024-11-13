drop table inscripciones_mallas_det

CREATE TABLE inscripciones_plan_curso (
	id serial,
	id_alumno int4 NULL,
	id_plan_curso int4 NULL,
	fecha date NULL,
	CONSTRAINT pk_inscripciones_plan_curso PRIMARY KEY (id)
);


-- public.inscripciones_mallas_det foreign keys

ALTER TABLE public.inscripciones_plan_curso ADD CONSTRAINT fk_inscripciones_alumnos FOREIGN KEY (id_alumno) REFERENCES public.alumnos(id);
ALTER TABLE public.inscripciones_plan_curso ADD CONSTRAINT fk_inscripciones_plan_curso FOREIGN KEY (id_plan_curso) REFERENCES public.planes_cursos(id);

