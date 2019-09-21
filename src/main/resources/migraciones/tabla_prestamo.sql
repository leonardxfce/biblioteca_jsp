CREATE TABLE `prestamo`(
    `idPrestamo` int(11),
    `Socio_idSocio` int(11),
    FOREIGN KEY `Socio_idSocio` REFERENCES `socio`(`idSocio`),
    `Libro_idlibro` int(11),
    FOREIGN KEY `Libro_idlibro` REFERENCES `libro`(`idlibro`),
    `numPrestamo` int(11),
    `Fecha` date,
    `Plazo` Int(11),
    `Estado_idEstado`(11),
    FOREIGN KEY `Estado_idEstado` REFERENCES `estado`(`idEstado`)
);