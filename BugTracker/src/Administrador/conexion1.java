package Administrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion1 {

    static Connection con;

    public static Connection getConexion() {
        String conexionUr1 = "jdbc:sqlserver://localhost:1433;"
                + "database=db_ProyectoFinal;"
                + "user=sa;"
                + "password=1234;"
                + "loginTimeout=30";
        try {
            con = DriverManager.getConnection(conexionUr1);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
