package modelos;

import modelo.Autor;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutorTest {

    @Test
    public void prepararInsert() {
        String esperado = "INSERT INTO `biblioteca`.`autor` VALUES ('Antoine', 'de Saint-Exupéry');";
        Autor autor = new Autor();
        autor.setNombre("Antoine");
        autor.setApellido("de Saint-Exupéry");
        String resultado = autor.prepararInsert();
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararSelectTodos() {
        String esperado = "SELECT `idAutor`, concat(`Nombre`,`Apellido`) as `Autor` FROM `autor` ORDER BY `Autor` ASC;";
        Autor autor = new Autor();
        String resultado = autor.prepararSelectTodos();
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararUpdate() {
        String esperado = "UPDATE `autor` SET `nombre` = 'Antoine', `apellido` = 'de Saint-Exupéry' WHERE `idAutor` = 1;";
        Autor autor = new Autor();
        autor.setNombre("Antoine");
        autor.setApellido("de Saint-Exupéry");
        String resultado = autor.prepararUpdate("1");
        assertEquals(esperado, resultado);
    }

    @Test
    public void comprobarExistenciaDeRegistro() {
        String esperado = "SELECT count(*) as `Autor` FROM `biblioteca`.`autor` WHERE `autor`.`Nombre` = 'Antoine' && `autor`.`Apellido` ='de Saint-Exupéry';";
        Autor autor = new Autor();
        String[] data = new String[3];
        data[1] = "Antoine";
        data[2] = "de Saint-Exupéry";
        String resultado = autor.prepararComprobarExistenciaDeRegistro(data);
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararDelete() {
        String esperado = "DELETE FROM `biblioteca.autor` WHERE `idAutor` = 1;";
        Autor autor = new Autor();
        String resultado = autor.prepararDelete(1);
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararSelectUno() {
        String esperado = "SELECT `Nombre`, `Apellido` FROM `biblioteca`.`autor` WHERE `idAutor` = 1;";
        Autor autor = new Autor();
        String resultado = autor.prepararSelectUno("1");
        assertEquals(esperado, resultado);
    }
}


