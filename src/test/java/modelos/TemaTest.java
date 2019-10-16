package modelos;
import org.junit.Test;
import modelo.Tema;

public class TemaTest {
    
   @Test
    public void testNombreTema(){
        Tema t = new Tema();
        t.setNombreTema("Ficción");
        String resultado = t.NombreTema();
        String esperado = "Ficción";
        assertEquals(esperado,resultado);
    }

    private void assertEquals(String esperado, String resultado) {
     throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
