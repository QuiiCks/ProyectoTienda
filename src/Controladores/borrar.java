package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class borrar {
	public static Connection conexionBBDD() throws SQLException {
		// CONEXION CON LA BASE DE DATOS
		String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbName = "ProyectoTienda";
		String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
		String user = "root";
		String password = "manolo";

		Connection conexion = DriverManager.getConnection(url, user, password);
		return conexion;
	}
	public static void borrar(JTextField textMatricula) throws SQLException {
		String matricula = textMatricula.getText();
		Statement consulta = conexionBBDD().createStatement();
		int resultado;
		PreparedStatement consultaprep = conexionBBDD().prepareStatement("DELETE FROM coches WHERE Matricula = ?");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se han borrado todos los datos de la matricula "+matricula+" de la base de datos.");
	}
}
