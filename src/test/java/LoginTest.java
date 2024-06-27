
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import db.UsuarioDAO;

public class LoginTest {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    @Test
    public void testIngresarUsuarioCorrecto() {
              
        String username = "usuario1";
        String password = "password1";

        boolean result = usuarioDAO.validarCredenciales(username, password);
                
        assertTrue(result, "Las credenciales deberían ser válidas.");
        System.out.println(result);
    }

    @Test
    public void testIngresarUsuarioIncorrecto() {
        String username = "usuario_incorrecto";
        String password = "contrasena_incorrecta";
        
        boolean result = usuarioDAO.validarCredenciales(username, password); 

        assertFalse(result, "Las credenciales deberían ser incorrectas");
        System.out.println(result);
    }

    @Test
    public void testIngresarValoresVacios() {
        String username = "";
        String password = "";

        boolean result = usuarioDAO.validarCredenciales(username, password);
        
        assertFalse(result, "Las credenciales deberían ser incorrectas");
        System.out.println(result);
    }
}