SELECT codLibro.codLibro, libro.Titulo, tema.NombreTema,(select group_concat(autor.Nombre, autor.Apellido)
from libro_has_autor 
INNER JOIN autor
ON libro_has_autor.autor_idAutor = autor.idAutor
WHERE libro_has_autor.libro_idlibro = codlibro.idlibro) as autor,
codlibro.idlibro
FROM codLibro
INNER JOIN libro
ON codLibro.idlibro = libro.idlibro
JOIN tema
ON libro.Tema_idTema = tema.idTema
WHERE libro.Prestable = 1
Order By Titulo ASC;
