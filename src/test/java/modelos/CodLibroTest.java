package modelos;

import modelo.CodLibro;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CodLibroTest{
    @Test
    public void testInsertarCodLibro(){
        String esperado = "INSERT INTO `biblioteca`.`codlibro`(`codLibro`) VALUES (`34b`);";
        CodLibro codLibro = new CodLibro();
        codLibro.setCodlibro("34b");
        String resultado = codLibro.prepararInsert();
        assertEquals(esperado, resultado);
    }

    @Test
    public void testSelectUno(){
        String esperado = "SELECT `codlibro` FROM `codlibro` WHERE `idlibro` = `35C`;";
        CodLibro codLibro = new CodLibro();
        String resultado = codLibro.prepararSelectUno("35C");
        assertEquals(esperado, resultado);
    }

    @Test
    public void testPrepararBorrarCodigo(){
        String esperado = "DELETE FROM `biblioteca`.`codlibro` WHERE `codLibro` = `64a`;";
        CodLibro codLibro = new CodLibro();
        String resultado = codLibro.prepararBorrarCodigo("64a");
        assertEquals(esperado, resultado);
    }

    @Test
    public void testPrepararComprobarCodigo(){
        String esperado = "Select `codLibro` FROM `codLibro` WHERE `codLibro`.`codLibro` = 33l;";
        CodLibro codLibro = new CodLibro();
        String resultado = codLibro.prepararComprobarCodigo("33l");
        assertEquals(esperado, resultado);
    }
}