CREATE TABLE `codlibro`(
    `codLibro` int(11) PRIMARY KEY,
    `idlibro` int(11),
    FOREIGN KEY `idlibro` REFERENCES `libro`(`idlibro`)
);