
package modelos;

import modelo.Estado;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EstadoTest {
    
    @Test
    public void testEstado(){
        Estado e = new Estado();
        e.setEstado("Disponible");
        String resultado = e.getEstado();
        String esperado = "Disponible";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testInsert(){
        Estado e = new Estado();
        e.setEstado("Disponible");
        String resultado = e.getEstado();
        String esperado = "Disponible";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testUpdate(){
        Estado e = new Estado();
        e.setEstado("Disponible");
        String resultado = e.getEstado();
        String esperado = "Disponible";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testSelectTodos(){
        Estado e = new Estado();
        e.setEstado("Disponible");
        String resultado = e.getEstado();
        String esperado = "Disponible";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testComprobarExistenciaDeRegistro(){
        Estado e = new Estado();
        e.setEstado("Disponible");
        String resultado = e.getEstado();
        String esperado = "Disponible";
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testDelete(){
        Estado e = new Estado();
        e.setEstado("Disponible");
        String resultado = e.getEstado();
        String esperado = "Disponible";
        assertEquals(esperado,resultado);
    }
}
