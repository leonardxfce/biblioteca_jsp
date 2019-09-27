CREATE TABLE `usuario`(
    `idUsuario` int PRIMARY KEY,
    `user` varchar(45),
    `pass` varchar(45),
    `nombre` varchar(45),
    `apellido` varchar(45),
    `dni` int(11),
    `tipoUsuario` int(11),
    `socio_idSocio` int(11),
    FOREIGN KEY(`socio_idSocio`) REFERENCES `socio`(`idSocio`),
    `estado_actividad` int(1),
    `ultimo_ingreso` date
);