package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/tienda?useSSL=false";

    public static void connectDatabase() throws Exception {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion establecida");
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al conectarse");
        }
    }

    public static void disconnectDatabase() throws Exception {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new Exception("Error al desconectarse");
        }
    }

    public static void insertModifyDelete(String sql) throws Exception {
        try {
            connectDatabase();
            //statement = connection.createStatement();
            //statement.executeUpdate(sql);
            connection.createStatement().executeUpdate(sql);
            System.out.println("Cambios guardados");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new Exception("Error al ejecutar rollback");
            }
            throw new Exception("Error al ejecutar sentencia");
        } finally {
            disconnectDatabase();
        }
    }

    public static ResultSet queryDatabase(String sql) throws Exception {

        try {
            connectDatabase();
            //statement = connection.createStatement();
            //resultSet = statement.executeQuery(sql);
            return connection.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new Exception("Error al consultar");
        }
    }
}
