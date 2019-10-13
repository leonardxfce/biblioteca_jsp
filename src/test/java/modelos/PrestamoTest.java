
package modelos;

import modelo.Prestamo;
import org.junit.Test;

import static org.junit.Assert.*;
import java.sql.Date;
public class PrestamoTest {
    @Test
    public void prepareInsertTest(){
    String esperado ="INSERT INTO `prestamo`(`Socio_idSocio`,`Libro_idlibro`,`numPrestamo`,`Fecha`,`Plazo`,`Estado_idEstado`)VALUES(2,22,18,'2019-05-20',5,1);";
    Prestamo prestamo = new Prestamo();
    prestamo.setSocio(2);
    prestamo.setLibro(22);
    prestamo.setNumPrestamo(18);
    Date date = new Date(119,4,20);
    prestamo.setFecha(date);
    prestamo.setPlazo(5);
    prestamo.setEstado(1);
    String resultado = prestamo.prepareInsert();
    assertEquals(esperado,resultado);

}
 @Test
 public void prepararUpdateTest(){
     String esperado= "UPDATE `prestamo` SET `Estado_idEstado` = 1 WHERE `numPrestamo` = '3';";
     Prestamo prestamo = new Prestamo();
     prestamo.setEstado(1);
     String resultado = prestamo.prepareUpdate("3");
     assertEquals(esperado,resultado);
 }
    
}
