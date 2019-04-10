package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Aplicacion.MenuTienda;
import Aplicacion.MenuTiendaAdmin;
import login.Login;

public class buttons {
	/**
	 * CONEXION CON LA BASE DE DATOS
	 * @return
	 * @throws SQLException
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
	/**
	 * METODO QUE CONTROLA EL BOTON DE LOGIN PARA ACCEDER A LA APLICACION
	 * @param textUser
	 * @param textPassword
	 * @return
	 * @throws SQLException
	 */
	public static void buttonLogin(JTextField textUser, JTextField textPassword) throws SQLException {

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
					if(resultado.getString("rol").equals("Admin")) {
						JOptionPane.showMessageDialog(null, " Logeado correctamente con rol de Administrador");
						MenuTiendaAdmin.main(null);
					}else {
						JOptionPane.showMessageDialog(null, " Logeado correctamente");
						MenuTienda.main(null);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
				}
			}

		} else {
			JOptionPane.showMessageDialog(null, "Usuario incorrecto");
		}
	}
	/**
	 * METODO QUE CONTROLA EL BOTON REGISTER Y AÑADE UN USUARIO
	 * @param textUser
	 * @param textPassword
	 * @throws SQLException
	 */
	public static void buttonRegister(JTextField textUser, JTextField textPassword) throws SQLException {
		String usuario = textUser.getText();
		String password = textPassword.getText();

		Statement consulta = conexionBBDD().createStatement();
		int resultado;
		PreparedStatement consultaprep = conexionBBDD().prepareStatement("INSERT INTO users (user,password,rol) VALUES (?, ?, '')");
		consultaprep.setString(1, usuario);
		consultaprep.setString(2, password);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se ha añadido el usuario " + usuario + " con contraseña " + password + " en la base de datos.");
		
	}

}
