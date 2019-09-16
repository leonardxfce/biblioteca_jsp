CREATE TABLE libro(
    idlibro int(11) PRIMARY KEY,
    Titulo varchar(120),
    Prestable int(11),
    Tema_idTema int(11),
    FOREIGN KEY Tema_idTema REFERENCES tema(idTema),
    Ubicacion_id_ubicacion int(11),
    FOREIGN KEY Ubicacion_id_ubicacion REFERENCES ubicacion(id_ubicacion)
);