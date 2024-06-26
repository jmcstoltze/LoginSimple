package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {               
    
    // Consulta a la tabla Usuario de la DB
    private static final String USUARIO_QUERY = 
            "SELECT * FROM Usuario WHERE Username = ? AND Password = ?";
    
    // Consulta a la tabla Usuario de la DB para obtener el Rut por username
    private static final String OBTENER_RUT_QUERY = 
            "SELECT Rut FROM Usuario WHERE Username = ?";
    
    // Método para validar las credenciales
    public boolean validarCredenciales(String username, String password) {
        
        // Declara variables a utilizar
        boolean isValid = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            connection = DBConnection.getConnection();
            stmt = connection.prepareStatement(USUARIO_QUERY);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            
            // Si el resulrtado de la consulta contiene información
            if (rs.next()) {
                isValid = true; // Usuario y contraseña validados
            }
            
        // Manejo de excepciones
        } catch (SQLException e) {
            e.printStackTrace();
            
        // Cierre de los procesos al finalizar
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return isValid; // Retorna la validación true or false
    }
    
    public String obtenerRutPorUsername(String username) {
        String rut = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            connection = DBConnection.getConnection();
            stmt = connection.prepareStatement(OBTENER_RUT_QUERY);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                rut = rs.getString("Rut");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return rut;
    }
    
}
