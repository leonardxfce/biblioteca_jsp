package modelos;

import modelo.Socio;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class SocioTest {

    @Test
    public void TestGetApellido() {
        Socio socio = new Socio();
        socio.setApellido("Gregorio");
        String resultado = socio.getApellido();
        String esperado = "Gregorio";
        assertEquals(esperado, resultado);
    }

    @Test
    public void TestNombre() {
        Socio socio = new Socio();
        socio.setNombre("Flavia");
        String resultado = socio.getNombre();
        String esperado = "Flavia";
        assertEquals(esperado, resultado);
    }

    @Test
    public void TestDni() {
        Socio socio = new Socio();
        socio.setDNI(42084417);
        int resultado = socio.getDNI();
        int esperado = 42084417;
        assertEquals(esperado, resultado);
    }

    @Test
    public void TestCarrera() {
        Socio socio = new Socio();
        socio.setCarrera(4);
        int resultado = socio.getCarrera();
        int esperado = 4;
        assertEquals(esperado, resultado);
    }

    @Test
    public void prepararInsert() {
        String esperado = "INSERT INTO `biblioteca`.`socio` (`Carrera_idCarrera`,`Nombre`,`Apellido`, `DNI`, `estado_actividad`) VALUES (1, 'Flavia', 'Gregorio', '42084417', 0);";
        Socio socio = new Socio();
        socio.setCarrera(1);
        socio.setNombre("Flavia");
        socio.setApellido("Gregorio");
        socio.setDNI(42084417);
        String resultado = socio.prepararInsert();
        assertEquals(esperado, resultado);
    }
    @Test
     public void prepararSelectTodos(){
         Socio socio = new Socio();
         String esperado = "SELECT `idSocio`, concat(`Nombre`,' ',`Apellido`,' - DNI: ',`DNI`) AS `Socio` FROM `socio` WHERE `estado_actividad` = 0;";
         String resultado = socio.prepararSelectTodos();
         assertEquals(esperado, resultado);
     }

     @Test
     public void prepararAltaUsuario(){
         Socio socio = new Socio();
         String esperado = "UPDATE socio INNER JOIN usuario ON socio.idSocio = usuario.socio_idSocio SET socio.estado_actividad = 0, usuario.estado_actividad = 0 WHERE socio.DNI = 42084417;";
         String resultado = socio.prepararAltaUsuario("42084417");
         assertEquals(esperado, resultado);
     }

     
}


