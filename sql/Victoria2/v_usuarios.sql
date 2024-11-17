drop view if exists v_usuarios;
create view v_usuarios
as
	select
		u.id as id,
		u.username as username,
		u.password as password,

		coalesce((select true
				  from roles_usuarios ru
				  inner join roles r on (r.id = ru.id_rol)
				  where ru.id_usuario = u.id
				  and r.rolename in ('ADMIN', 'SEGURIDAD')
				  limit 1), false) as seguridad,

		coalesce((select true
				  from roles_usuarios ru
				  inner join roles r on (r.id = ru.id_rol)
				  where ru.id_usuario = u.id
				  and r.rolename in ('ADMIN', 'REFERENCIAL')
				  limit 1), false) as referencial,

		coalesce((select true
				  from roles_usuarios ru
				  inner join roles r on (r.id = ru.id_rol)
				  where ru.id_usuario = u.id
				  and r.rolename in ('ADMIN', 'COORDINACION')
				  limit 1), false) as coordinacion,

		coalesce((select true
				  from roles_usuarios ru
				  inner join roles r on (r.id = ru.id_rol)
				  where ru.id_usuario = u.id
				  and r.rolename in ('ADMIN', 'DIRECTIVO')
				  limit 1), false) as directivo,
	 coalesce((select true
				  from roles_usuarios ru
				  inner join roles r on (r.id = ru.id_rol)
				  where ru.id_usuario = u.id
				  and r.rolename in ('ADMIN', 'SECRETARIA')
				  limit 1), false) as secretaria,


		(select id
		from docentes d
		where d.nro_cedula = u.nro_cedula
		limit 1) as id_docente,

		true as conectado
	from
		usuarios u;