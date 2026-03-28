# UDR - Unidad Diagnóstica Rural

## ¿Qué es UDR?
UDR es una empresa de servicio móvil de resonancia magnética diseñada para acercar la tecnología diagnóstica de alta resolución a poblaciones rurales que carecen de acceso a este tipo de pruebas médicas.

## ¿Qué problema resuelve?
Más de 8.000 municipios españoles, la mayoría con menos de 5.000 habitantes, no tienen acceso cercano a una resonancia magnética. Los pacientes rurales deben recorrer decenas de kilómetros y esperar meses para realizarse una prueba básica. UDR lleva la unidad móvil hasta el municipio del paciente, integrándose en el circuito de la sanidad pública sin cambiar los procedimientos habituales.

## Tecnologías utilizadas
- HTML5
- CSS3 (Flexbox, Grid, variables CSS, media queries)
- Google Fonts (Bree Serif, Roboto)
- Java (próximamente)
- MySQL 

## Módulos del proyecto
- /bases_de_datos — Bases de Datos 
- /lenguajes_marcas — Lenguajes de Marcas 
- /programacion — Programación  y MPO
- /sistemas — Sistemas Informáticos 

## Base de datos
La base de datos modela el funcionamiento interno de UDR. Gestiona la información de pacientes, especialistas, unidades móviles, municipios, citas, tipos de prueba e informes.

Las tablas principales son:
- **pacientes** — personas que solicitan una prueba diagnóstica
- **especialista** — médicos que solicitan y redactan los informes
- **unidadMovil** — vehículos equipados con resonancia magnética
- **municipio** — poblaciones rurales donde se desplaza la unidad
- **citas** — reservas que conectan paciente, especialista, unidad y municipio
- **tipoPrueba** — tipos de resonancia disponibles por categoría y zona
- **informe** — resultado de cada prueba vinculado a la cita y al paciente
- **ruta** — tabla intermedia que registra qué unidad va a qué municipio y cuándo

## Instrucciones de ejecución
1. Clona o descarga el repositorio
2. Abre el archivo `lenguajes_marcas/index.html` con cualquier navegador web
3. Navega por las páginas desde el menú de navegación
No requiere instalación ni servidor.

## Estructura del repositorio

```text
UDR-Diagnostica-Rural/
├── bases_de_datos/
│   ├── diagramas/
│   │   ├── Diagrama_UDR.drawio
│   │   ├── Diagrama_UDR.png
│   │   ├── Diagrama_UDR_relacional.drawio
│   │   └── Diagrama_UDR_relacional.png
│   └── sql/
│       ├── crearTablas.sql
│       ├── datos.sql
│       └── consultas.sql
├── lenguajes_marcas/
│   ├── index.html
│   ├── Servicios.html
│   ├── SobreUDR.html
│   ├── Cobertura.html
│   ├── Contacto.html
│   ├── style.css
│   ├── Imágenes/
│   └── Videos/
├── programacion/
├── sistemas/
└── README.md
```

## Páginas
- **Inicio** — Presentación del servicio, ventajas, cómo funciona y llamada a la acción
- **Servicios** — Tipos de estudios, proceso asistencial y tecnología y equipamiento
- **Sobre UDR** — Historia de la empresa, el problema que resuelve y misión y valores
- **Contacto** — Formulario de contacto para solicitar información
- **Cobertura** — Buscador de municipios cubiertos por comunidad autónoma