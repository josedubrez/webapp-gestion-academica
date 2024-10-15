drop view if exists v_confirmar_clase;

create view v_confirmar_clase
as
	select
		pc.id as id,
		pc.id as id_plan_curso,
		pc.id_docente as id_docente,
		pch.id as id_plan_curso_horario,
		current_date as fecha
	from
		planes_cursos pc
		inner join planes_cursos_horarios pch on (
												  pch.id_plan_curso = pc.id
												  and now()::time between pch.horario_desde and pch.horario_hasta
												  and (extract(dow from current_date) + 1) = pch.id_dia_semana
												  )
	where
		current_date between pc.fecha_inicio and pc.fecha_fin
		and not exists (select 1
						from feriados f
						where f.fecha = current_date
						and (f.id_sede = pc.id_sede or f.id_sede is null))
		and not exists (select 1
						from clases c
						where c.fecha = current_date
						and c.id_plan_curso = pc.id
						and ((c.horario_desde between pch.horario_desde and pch.horario_hasta) or
							 (c.horario_hasta between pch.horario_desde and pch.horario_hasta))
						)
	limit 1;