package modelos;

import modelo.Socio;
import org.junit.Test;

import static org.junit.Assert.*;

public class SocioTest {

    @Test
    public void TestGetApellido() {
        Socio socio = new Socio();
        socio.setApellido("Gregorio");
       String resultado=socio.getApellido();
       String esperado="Gregorio";
        assertEquals(esperado, resultado);
    }
   
    @Test
    public void TestNombre() {
        Socio socio = new Socio();
        socio.setNombre("Flavia");
       String resultado=socio.getNombre();
       String esperado ="Flavia";
        assertEquals(esperado, resultado);
    }
    @Test
    public void TestDni() {
        Socio socio = new Socio();
        socio.setDNI(42084417);
       int resultado=socio.getDNI();
       int esperado =42084417;
        assertEquals(esperado, resultado);
    }
    @Test
    public void TestCarrera() {
        Socio socio = new Socio();
        socio.setCarrera(4);
       int resultado=socio.getCarrera();
       int esperado =4;
        assertEquals(esperado, resultado);
    }
   
    

 
}


