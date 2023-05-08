
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionDB {

    Connection con;//Intancia de Connection 
    String driver = "com.mysql.jdbc.Driver"; //Libreria version 5
    //String driver = "com.mysql.cj.jdbc.Driver"; //Libreria version 8
    String dbName = "inventario";
    String url = "jdbc:mysql://localhost:3306/" + dbName ; // Url de base de datos
    String usuario = "root"; // Variable para usuario de la base de datos
    String password = ""; // Variable para usuario de la base de datos

    public Connection ConectarBaseDatos() throws SQLException {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, usuario, password);
            System.out.println("Coneccion Correcta");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion:" + e);
        }
        return con;
    }
}

/*class Prueba {

    Connection con;
    ConexionDB conexion = new ConexionDB();
    con = conexion.ConectarBaseDatos();
}*/
