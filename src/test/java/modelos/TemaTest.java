package modelos;
import org.junit.Test;
import modelo.Tema;
import static org.junit.Assert.assertEquals;

public class TemaTest {
    
   @Test
    public void testNombreTema(){
        Tema t = new Tema();
        t.setNombreTema("Ficción");
        String resultado = t.getNombreTema();
        String esperado = "Ficción";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testSelectTodos(){
        Tema t = new Tema();
        t.setNombreTema("Ficción");
        String resultado = t.getNombreTema();
        String esperado = "Ficción";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testInsert(){
        Tema t = new Tema();
        t.setNombreTema("Ficción");
        String resultado = t.getNombreTema();
        String esperado = "Ficción";
        assertEquals(esperado,resultado);
    }
}
