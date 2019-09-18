SELECT count(codLibro) FROM codLibro
        INNER JOIN libro 
        ON codlibro.idlibro = libro.idlibro
        WHERE libro.Prestable = 1;