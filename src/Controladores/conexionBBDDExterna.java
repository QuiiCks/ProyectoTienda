package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionBBDDExterna {
	public static Connection conexionBBDD() throws SQLException {
		// CONEXION CON LA BASE DE DATOS
		String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbName = "YEnucEI9ee";
		String url = "jdbc:mysql://remotemysql.com:3306/" + dbName + timeZone;
		String user = "YEnucEI9ee";
		String password = "URwtFF1NOa";

		Connection conexion = DriverManager.getConnection(url, user, password);
		return conexion;
	}
}
