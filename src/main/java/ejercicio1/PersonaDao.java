package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class PersonaDao {
    private Connection obtenerConexion() {
        Connection conn = null;
        try {
            conn = ConnectionManager.getConnection();
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Persona personaPorId(int id) {
        String sql = "select p.nombre "
                + "from personas p "
                + "where p.id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement =
                     conn.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new ProxyTelefono(id, new TelefonoDao());
            String nombrePersona = null;
            while (result.next()) {
                nombrePersona = result.getString(1);
            }
            return new Persona(id, nombrePersona, telefonos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

