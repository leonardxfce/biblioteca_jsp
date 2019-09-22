package modelos;

import modelo.Libro;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibroTest {

    @Test
    public void prepararInsert() {
        String esperado = "INSERT INTO `biblioteca`.`libro`(`Titulo`, `Tema_idTema`, `Ubicacion_id_ubicacion`, `Prestable`) VALUES ('PEPITO', 1,1,1);";
        Libro libro = new Libro();
        libro.setTitulo("PEPITO");
        libro.setTema(1);
        String resultado = libro.prepararInsert();
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararUpdate() {
        String esperado = "UPDATE `biblioteca`.`libro` SET `Titulo` = 'PEPITO', `Tema_idTema` = 2 WHERE `idLibro` = 1;";
        Libro libro = new Libro();
        libro.setTitulo("PEPITO");
        libro.setTema(2);
        String resultado = libro.prepararUpdate(1);
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararContarLibros() {
        String esperado = "SELECT count(*) FROM `biblioteca`.`codLibro` INNER JOIN `biblioteca`.`libro` ON `codlibro`.`idlibro` = `libro`.`idlibro` WHERE `libro`.`idlibro` = 1 AND `libro`.`Prestable` = 1;";
        Libro libro = new Libro();
        String resultado = libro.prepararContarLibros("1");
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararComprobarExistenciaDeRegistro() {
        String esperado = "SELECT `idlibro` FROM `biblioteca`.`libro` WHERE `libro`.`Titulo` = PEPITO;";
        Libro libro = new Libro();
        String[] data = new String[5];
        data[1] = "PEPITO";
        String resultado = libro.prepararComprobarExistenciaDeRegistro(data);
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararSelectUno() {
        String esperado = "SELECT `idLibro`, `Titulo` ,`Tema_idTema` FROM `biblioteca`.`libro` WHERE `idLibro` = 2;";
        Libro libro = new Libro();
        String resultado = libro.prepararSelectUno("2");
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararUpdatePrestable() {
        String esperado = "UPDATE `biblioteca`.`libro` SET `Prestable` = 1 WHERE `idLibro` = 1;";
        Libro libro = new Libro();
        String resultado = libro.prepararUpdatePrestable(1, 1);
        assertEquals(esperado, resultado);
    }
}