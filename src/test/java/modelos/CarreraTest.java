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
}
