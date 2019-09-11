/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import modelo.Ubicacion;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author leonardlxde
 */
public class UbicacionTest {
    @Test
    public void testPrepararInsert(){
        String esperado = "INSERT INTO `biblioteca`.`ubicacion` (`sector`) VALUES ('Salon A');";
        Ubicacion u = new Ubicacion();
        u.setUbicacion("Salon A");
        String resultado = u.prepararInsert();
        assertEquals(esperado,resultado);
    }
    
}
