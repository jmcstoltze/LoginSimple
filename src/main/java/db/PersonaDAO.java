package db;

import models.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {

    private static final String PERSONA_QUERY =
            "SELECT * FROM Persona WHERE Rut = ?";

    public Persona obtenerPersonaPorRut(String rut) {
        Persona persona = null;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = DBConnection.getConnection();
            stmt = connection.prepareStatement(PERSONA_QUERY);
            stmt.setString(1, rut);
            rs = stmt.executeQuery();

            if (rs.next()) {
                persona = new Persona();
                persona.setRut(rs.getString("Rut"));
                persona.setNombres(rs.getString("Nombres"));
                persona.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                persona.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                persona.setTelefono(rs.getString("Telefono"));
                persona.setFechaIngreso(rs.getDate("FechaIngreso"));
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

        return persona;
    }
}
