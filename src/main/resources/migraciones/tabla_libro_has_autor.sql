CREATE TABLE libro_has_autor(
    libro_idlibro int(11),
    FOREIGN KEY libro_idlibro REFERENCES libro(idlibro),
    autor_idAutor int(11),
    FOREIGN KEY autor_idAutor REFERENCES autor(idAutor)
);