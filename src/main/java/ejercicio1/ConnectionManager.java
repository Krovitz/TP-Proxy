package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionManager {

    private static Properties prop = null;

    private static Properties getProperties() throws DataBaseConfigurationException {
        Properties prop = new Properties();
        try {
            ResourceBundle infoDataBase = ResourceBundle.getBundle("database");
            prop.setProperty("connection", infoDataBase.getString("db.url"));
            prop.setProperty("username", infoDataBase.getString("db.user"));
            prop.setProperty("password", infoDataBase.getString("db.password"));
        } catch (Exception e1) {
            throw new DataBaseConfigurationException("exceptionConnectionManager.error");
        }
        return prop;
    }

    public static Connection getConnection() throws SQLException {
        if (prop == null) {
            try {
                prop = getProperties();
            } catch (DataBaseConfigurationException e) {
                throw new SQLException("Error loading DB config", e);
            }
        }
        return DriverManager.getConnection(
                prop.getProperty("connection"),
                prop.getProperty("username"),
                prop.getProperty("password")
        );
    }
}


