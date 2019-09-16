CREATE TABLE socio(
    idSocio int PRIMARY KEY,
    Carrera_idCarrera INT(11),
    FOREIGN KEY Carrera_idCarrera REFERENCES carrera(idCarrera),
    Nombre varchar(120),
    apellido varchar(120),
    dni int(11),
    estado_de_deuda TINYINT(4),
    estado_de_actividad TINYINT(4)
);