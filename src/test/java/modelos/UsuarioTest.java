package modelos;
import modelo.Usuario;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class UsuarioTest {
    @Test
    public void selectUsuarioTest(){
    String esperado = "SELECT * FROM `usuario` WHERE `user` = 'user' AND `pass` = 'pass';";
    Usuario usuario = new Usuario();
    usuario.setUser("Brian");
    usuario.setPass("1234");
    String resultado = usuario.selectUsuario2();
    assertEquals(esperado,resultado);
    }
    @Test
    public void insertTest(){
    String esperado = "INSERT INTO `usuario`(`user`, `pass`, `nombre`, `apellido`, `dni`, `tipoUsuario`, `estado_actividad`) VALUES ('user', 'pass', 'nombre', 'apellido', dni, 1, 0);";
    Usuario usuario = new Usuario();
    usuario.setUser("Brian");
    usuario.setTipoUsuario(1);
    String resultado = usuario.insert2();
    assertEquals(esperado,resultado);
}

}
