-- Cuántas unidades móviles están activas --

SELECT * FROM unidadmovil WHERE estado = 'activa';

-- Cuántas pruebas musculoesqueléticas duran menos de 30 minutos --

SELECT COUNT(*) FROM tipoprueba WHERE categoria = 'musculoesquelético' AND CAST(REPLACE(duracion, ' min', '') AS UNSIGNED)  <30;

-- Qué especialistas hay en la provincia de Asturias --

SELECT * FROM especialista WHERE provincia = 'Asturias';

-- Pacientes que han recibido un informe este mes --

SELECT DISTINCT p.nombre, p.id_pacientes, p.apellidos
FROM pacientes p
JOIN informe i 
ON p.id_pacientes = i.id_pacientes
WHERE i.fecha >= '2026-03-01' AND i.fecha <= '2026-03-31';

-- Cuántos pacientes han recibido un informe este mes --

SELECT COUNT(DISTINCT p.id_pacientes)
FROM pacientes p
JOIN informe i ON p.id_pacientes = i.id_pacientes
WHERE i.fecha >= '2026-03-01' AND i.fecha <= '2026-03-31';

-- Seleccionar todos los informes --

SELECT * FROM informe;

-- En qué hospitales hay un especialista neurológico --

SELECT hospital FROM especialista
WHERE especialidad = 'neurología';

-- Qué municipios tienen ruta hoy --

SELECT m.nombre
FROM ruta r
JOIN municipio m
ON m.id_municipio = r.id_municipio
WHERE fecha = '2026-03-23';

-- Todas citas pendientes con el nombre del paciente y el municipio --

SELECT c.estado, p.nombre, m.nombre
FROM citas c
JOIN municipio m
ON c.id_municipio = m.id_municipio
JOIN pacientes p
ON c.id_pacientes = p.id_pacientes
WHERE c.estado = 'pendiente';

-- Ver todos los informes con el nombre del paciente y el especialista que lo redactó --

SELECT i.id_informe, p.nombre, e.id_especialista, e.nombre
from informe i
JOIN pacientes p
ON i.id_pacientes = p.id_pacientes
JOIN especialista e
ON i.id_especialista = e.id_especialista;

-- Cuántas citas hay por municipio --

SELECT id_municipio, COUNT(*)
FROM citas
GROUP BY id_municipio;

-- Buscar un paciente por DNI --

SELECT * FROM pacientes
WHERE DNI = '23456789B';

-- Citas realizadas en un rango de fechas --

SELECT * FROM citas
WHERE fecha BETWEEN '2026-04-01' AND '2026-04-03';