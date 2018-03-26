package modelos;

import modelo.CodLibro;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CodLibroTest{
    @Test
    public void testInsertarCodLibro(){
        String esperado = "INSERT INTO `biblioteca`.`codlibro`(`codLibro`) VALUES (`34b`);";
        CodLibro codLibro = new CodLibro();
        codLibro.setCodLibro("34b");
        String resultado = codLibro.prepararInsert();
        assertEquals(esperado, resultado);
    }
}