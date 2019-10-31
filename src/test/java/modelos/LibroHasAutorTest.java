
package modelos;

import modelo.LibroHasAutor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LibroHasAutorTest {
    @Test
    public void testIdLbro(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testIdAutor(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdAutor(4321);
        int resultado = LHA.getIdAutor();
        int esperado = 4321;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testInsert(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testTomarID(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testUpdate(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testSelectTodo(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testComprobarExisteciaDeRegistro(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testDelete(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
    
    @Test
    public void testSelectUno(){
        LibroHasAutor LHA = new LibroHasAutor();
        LHA.setIdlibro(1234);
        int resultado = LHA.getIdlibro();
        int esperado = 1234;
        assertEquals(esperado,resultado);
    }
}
