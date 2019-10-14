package modelos;

import modelo.Prestamo;
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.Date;

public class PrestamoTest {

    @Test
    public void prepareInsertTest() {
        String esperado = "INSERT INTO `prestamo`(`Socio_idSocio`,`Libro_idlibro`,`numPrestamo`,`Fecha`,`Plazo`,`Estado_idEstado`)VALUES(2,22,18,'2019-05-20',5,1);";
        Prestamo prestamo = new Prestamo();
        prestamo.setSocio(2);
        prestamo.setLibro(22);
        prestamo.setNumPrestamo(18);
        Date date = new Date(119, 4, 20);
        prestamo.setFecha(date);
        prestamo.setPlazo(5);
        prestamo.setEstado(1);
        String resultado = prestamo.prepareInsert();
        assertEquals(esperado, resultado);

    }

    @Test
    public void prepareUpdateTest() {
        String esperado = "UPDATE `prestamo` SET `Estado_idEstado` = 1 WHERE `numPrestamo` = '3';";
        Prestamo prestamo = new Prestamo();
        prestamo.setEstado(1);
        String resultado = prestamo.prepareUpdate("3");
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepareSelectTodosTest() {
        String esperado = "SELECT prestamo.numPrestamo, libro.Titulo, socio.DNI,socio.Nombre, socio.Apellido, carrera.nombreCarrera, prestamo.Plazo, prestamo.Fecha,date_add(Fecha,INTERVAL Plazo DAY),estado.Estado FROM prestamo INNER JOIN libro ON prestamo.Libro_idlibro = libro.idlibro JOIN socio ON prestamo.Socio_idSocio = socio.idSocio JOIN estado ON prestamo.Estado_idEstado = estado.idEstado JOIN carrera ON socio.Carrera_idCarrera = carrera.idCarrera;";
        Prestamo prestamo = new Prestamo();
        String resultado = prestamo.prepareSelectTodos();
        assertEquals(esperado, resultado);

    }
    
    @Test
    public void prepareContarTodosTest(){
        String esperado="SELECT count(*) FROM `prestamo` WHERE `Libro_idLibro` = 5 AND (`Estado_idEstado` = 1 OR Estado_idEstado = 2);";
        Prestamo prestamo = new Prestamo();
        String resultado = prestamo.prepareContarPrestamos("5");
        assertEquals(esperado,resultado);
        
    }
    @Test
    public void prepareUltimoPrestamo(){
        String esperado="SELECT max(numPrestamo) FROM `prestamo`;";
        Prestamo prestamo = new Prestamo();
        String resultado = prestamo.prepareUltimoPrestamo();
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void prepareComprobarDeudaConInfo(){
        String esperado="SELECT prestamo.Socio_idSocio, libro.Titulo, prestamo.Fecha FROM biblioteca.prestamo INNER JOIN libro ON prestamo.Libro_idlibro = libro.idlibro WHERE Socio_idSocio = 7 AND Estado_idEstado != 4;";
        Prestamo prestamo = new Prestamo();
        String resultado = prestamo.prepareComprobarDeudaConInfo("7");
        assertEquals(esperado,resultado);
    }    
}
