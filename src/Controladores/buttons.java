package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import login.Login;

public class buttons {
	/*
	 * CONEXION CON LA BASE DE DATOS
	 */
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
	
	public static boolean buttonLogin(JTextField textUser, JTextField textPassword) throws SQLException {

		String usuario = textUser.getText();
		String pass = textPassword.getText();

		Statement consulta = conexionBBDD().createStatement();
		ResultSet resultado;
		// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR EL USUARIO ESPECIFICO
		PreparedStatement consultaprep = conexionBBDD().prepareStatement("SELECT * FROM users WHERE user = ?");
		consultaprep.setString(1, usuario);
		resultado = consultaprep.executeQuery();

		if (resultado.next()) {
			// VERIFICACION DEL USUARIO
			if (resultado.getString("user").equals(usuario)) {

				// VERIFICACION DE CONTRASEÑA UNA VEZ EL USUARIO ES CORRECTO
				if (resultado.getString("password").equals(pass)) {
					// ACCESO AL PROGRAMA
					JOptionPane.showMessageDialog(null, " Logeado correctamente!");
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Usuario incorrecto");
		}
		return false;
	}
	public static void buttonRegister(JTextField textUser, JTextField textPassword) throws SQLException {
		String usuario = textUser.getText();
		String password = textPassword.getText();


		String instruccionSql = "INSERT INTO users values('" + usuario + "', '" + password + "')";

		Statement consulta = conexionBBDD().createStatement();
		consulta.executeUpdate(instruccionSql);
		JOptionPane.showMessageDialog(null, "Se ha añadido el usuario " + usuario + " con contraseña " + password + " en la base de datos.");
		
	}

}
