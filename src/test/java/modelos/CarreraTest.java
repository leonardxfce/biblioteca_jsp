package modelos;

import modelo.Carrera;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CarreraTest {
@Test
    public void testInsertCarrera(){
    String esperado = "INSERT INTO `biblioteca`.`carrera` (`nombreCarrera`) VALUES ('Desarrollo de Software');";
    Carrera C = new Carrera();
    C.setNombreCarrera("Desarrollo de Software");
    String resultado = C.insert2();
    assertEquals(esperado,resultado);
     }
   @Test 
    public void testActualizar(){
    String esperado = "UPDATE `carrera` SET `nombreCarrera` = '{nombreCarrera}' WHERE `carrera`.`idCarrera` = ('{id}');";
    Carrera C = new Carrera();
    C.setNombreCarrera("Analisis de Sistemas");
    String resultado = C.update2();
    assertEquals(esperado,resultado);
    }
    @Test
    public void testBorrar(){
    String esperado = "DELETE FROM `carrera` WHERE `idCarrera` = ('{id)');";
    Carrera C = new Carrera();
    C.setNombreCarrera("Desarrollo de Software");
    String resultado = C.delete2();
    assertEquals(esperado,resultado);
    }
    @Test
    public void testSelectUno(){
    String esperado = "SELECT nombreCarrera FROM biblioteca.carrera WHERE idCarr era = '{id}';";
    Carrera C = new Carrera();
    C.setNombreCarrera("Desarrollo de Software");
    String resultado = C.selectUno2();
    assertEquals(esperado,resultado);
    }
    @Test
    public void testSelectTodos(){
    String esperado = "SELECT `idCarrera`,`nombreCarrera` FROM `carrera` ORDER BY `nombreCarrera` ASC;";
    Carrera C = new Carrera();
    C.setNombreCarrera("Desarrollo de Software");
    String resultado = C.selecTodos2();
    assertEquals(esperado,resultado);
    }
    @Test
    public void testComprobarExistencia(){
    String esperado = "SELECT count(*) FROM carrera WHERE nombreCarrera = '{id}';";
    Carrera C = new Carrera();
    C.setNombreCarrera("Desarrollo de Software");
    String resultado = C.comprobarExistenciaDeRegistro2();
    assertEquals(esperado,resultado);
    
    }
}
