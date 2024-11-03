drop view v_usuarios source

CREATE OR REPLACE VIEW public.v_usuarios
AS SELECT u.id,
    u.username,
    u.password,
    COALESCE(( SELECT true AS bool
           FROM roles_usuarios ru
             JOIN roles r ON r.id = ru.id_rol
          WHERE ru.id_usuario = u.id AND (r.rolename::text = ANY (ARRAY['ADMIN'::character varying, 'SEGURIDAD'::character varying]::text[]))
         LIMIT 1), false) AS seguridad,
    COALESCE(( SELECT true AS bool
           FROM roles_usuarios ru
             JOIN roles r ON r.id = ru.id_rol
          WHERE ru.id_usuario = u.id AND (r.rolename::text = ANY (ARRAY['ADMIN'::character varying, 'REFERENCIAL'::character varying]::text[]))
         LIMIT 1), false) AS referencial,
    COALESCE(( SELECT true AS bool
           FROM roles_usuarios ru
             JOIN roles r ON r.id = ru.id_rol
          WHERE ru.id_usuario = u.id AND (r.rolename::text = ANY (ARRAY['ADMIN'::character varying, 'SECRETARIA'::character varying]::text[]))
         LIMIT 1), false) AS secretaria,
         COALESCE(( SELECT true AS bool
           FROM roles_usuarios ru
             JOIN roles r ON r.id = ru.id_rol
          WHERE ru.id_usuario = u.id AND (r.rolename::text = ANY (ARRAY['ADMIN'::character varying, 'COORDINACION'::character varying]::text[]))
         LIMIT 1), false) AS coordinacion,
    COALESCE(( SELECT true AS bool
           FROM roles_usuarios ru
             JOIN roles r ON r.id = ru.id_rol
          WHERE ru.id_usuario = u.id AND (r.rolename::text = ANY (ARRAY['ADMIN'::character varying, 'DOCUMENTAL'::character varying]::text[]))
         LIMIT 1), false) AS documental,
    COALESCE(( SELECT true AS bool
           FROM roles_usuarios ru
             JOIN roles r ON r.id = ru.id_rol
          WHERE ru.id_usuario = u.id AND (r.rolename::text = ANY (ARRAY['ADMIN'::character varying, 'OPERATIVO'::character varying]::text[]))
         LIMIT 1), false) AS operativo,
    ( SELECT d.id
           FROM docentes d
          WHERE d.nro_cedula::text = u.nro_cedula::text
         LIMIT 1) AS id_docente,
    true AS conectado
   FROM usuarios u;