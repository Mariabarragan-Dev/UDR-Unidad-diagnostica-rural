CREATE DATABASE UDR;

CREATE TABLE municipio (
     id_municipio int AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(50) not null, 
     provincia VARCHAR(50) not null, 
     c_autonoma VARCHAR(50) not null 
     );

CREATE TABLE pacientes (
id_pacientes int AUTO_INCREMENT PRIMARY KEY,
    DNI VARCHAR(50) UNIQUE NOT null,
    nombre VARCHAR(50) not null,
    apellidos VARCHAR(50) not null,
    fecha_nacimiento DATE not null,
    telefono VARCHAR(50) not null,
    id_municipio int not null, 
    FOREIGN KEY (id_municipio) REFERENCES municipio (id_municipio)
); 

CREATE TABLE especialista (
id_especialista int AUTO_INCREMENT PRIMARY KEY,
    especialidad VARCHAR(50) NOT null,
    nombre VARCHAR(50) not null,
    apellidos VARCHAR(50) not null,
    hospital VARCHAR (50) not null,
    provincia VARCHAR(50) not null,
    telefono VARCHAR (50) null
); 

CREATE TABLE unidadMovil (
id_unidadMovil int AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(20) NOT null,
    estado VARCHAR(50) not null,
    modelo VARCHAR(50) not null   
); 

CREATE TABLE tipoPrueba (
id_tipoPrueba  int AUTO_INCREMENT PRIMARY KEY,
    zona VARCHAR(50) NOT null,
    categoria VARCHAR(50) not null,
    duracion VARCHAR(30) null,
    preparacion VARCHAR(100)
);

CREATE TABLE citas (
id_citas int AUTO_INCREMENT PRIMARY KEY,
    hora time NOT null,
    estado VARCHAR(50) not null,
    fecha DATE not null,

    id_pacientes int not null, 
    FOREIGN KEY (id_pacientes) REFERENCES pacientes (id_pacientes),
    
    id_tipoPrueba int not null, 
    FOREIGN KEY (id_tipoPrueba) REFERENCES tipoprueba (id_tipoPrueba),
    
    id_especialista int not null, 
    FOREIGN KEY (id_especialista) REFERENCES especialista (id_especialista),
    
    id_unidadMovil int not null, 
    FOREIGN KEY (id_unidadMovil) REFERENCES unidadmovil (id_unidadMovil),   
    
    id_municipio int not null, 
    FOREIGN KEY (id_municipio) REFERENCES municipio (id_municipio)
); 

CREATE TABLE informe (
id_informe int AUTO_INCREMENT PRIMARY KEY,
    resultado VARCHAR(200) not null,
    fecha DATE not null,

    id_pacientes int not null, 
    FOREIGN KEY (id_pacientes) REFERENCES pacientes (id_pacientes),
    
    id_especialista int not null, 
    FOREIGN KEY (id_especialista) REFERENCES especialista (id_especialista),
     
    
    id_citas int not null, 
    FOREIGN KEY (id_citas) REFERENCES citas (id_citas)
); 

CREATE TABLE ruta (
    id_municipio INT NOT NULL,
    id_unidadMovil INT NOT NULL,

    fecha DATE NOT NULL,

    PRIMARY KEY (id_municipio, id_unidadMovil),
    FOREIGN KEY (id_municipio) REFERENCES municipio (id_municipio),
    
    FOREIGN KEY (id_unidadMovil) REFERENCES unidadmovil (id_unidadMovil)
);