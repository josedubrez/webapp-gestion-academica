
CREATE TABLE public.referenciales (
	id serial,
	id_materia int4 NULL,
	id_malla_det int4 null,
	CONSTRAINT pk_referencial_mallas PRIMARY KEY (id),
	CONSTRAINT uniq_referencial UNIQUE (id_materia, id_malla_det)
);
ALTER TABLE public.referenciales ADD CONSTRAINT fk_materias_mallas_det FOREIGN KEY (id_malla_det) REFERENCES public.mallas_det(id);
ALTER TABLE public.referenciales ADD CONSTRAINT fk_materias_referen_materias FOREIGN KEY (id_materia) REFERENCES public.materias(id);


-- DROP FUNCTION public.f_tr_ins_referenciales();

CREATE OR REPLACE FUNCTION public.f_tr_ins_referenciales()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
declare
	v_semestre integer;
begin
	select distinct 1
	into v_semestre
	from mallas_det md
	where md.id = new.id_malla_det
	and md.nro_semestre > (select md2.nro_semestre
						from mallas_det md2
						where md2.id_malla = md.id_malla
						and md2.id_materia = new.id_materia);

 if v_semestre is null then
        raise exception 'Materia a registrar debe ser de semetre inferior a la actual. Favor Verificar! ';
 end if;

 return new;

end;
$function$
;

create trigger tr_ins_referenciales after
insert
    on
    public.referenciales for each row execute procedure f_tr_ins_referenciales();

   create trigger tr_upd_referenciales after
update
    on
    public.referenciales for each row execute procedure f_tr_ins_referenciales();