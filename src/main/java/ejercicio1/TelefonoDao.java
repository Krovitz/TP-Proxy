package ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelefonoDao {

    private Connection obtenerConexion() {
        Connection conn = null;
        try {
            conn = ConnectionManager.getConnection();
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Telefono> telefonosPorPersona(int idPersona) {
        String sql = "SELECT numero FROM telefonos WHERE idPersona = ?";

        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, idPersona);
            ResultSet result = statement.executeQuery();

            List<Telefono> telefonos = new ArrayList<>();
            while (result.next()) {
                String numero = result.getString("numero");
                telefonos.add(new Telefono(numero));
            }
            return telefonos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
