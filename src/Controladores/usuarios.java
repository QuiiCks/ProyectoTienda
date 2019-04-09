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

import Aplicacion.MenuTiendaAdmin;

public class usuarios {
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

	public static void obtenerUsuarios(JComboBox usuarios) throws SQLException {

		Statement consulta = conexionBBDD().createStatement();
		ResultSet resultado;
		PreparedStatement consultaprep = conexionBBDD().prepareStatement("SELECT user FROM users");
		resultado = consultaprep.executeQuery();
		while (resultado.next()) {
			usuarios.addItem(resultado.getObject(1));
		}
	}

	public static void actualizarUsuarios(JComboBox usuarioscomboBox, JComboBox rolcomboBox) throws SQLException {
		String usuario = usuarioscomboBox.getSelectedItem().toString();
		String rol = rolcomboBox.getSelectedItem().toString();

		Statement consulta = conexionBBDD().createStatement();
		int resultado;

		PreparedStatement consultaprep = conexionBBDD().prepareStatement("UPDATE Users SET Rol = ? WHERE User = ?");
		consultaprep.setString(1, rol);
		consultaprep.setString(2, usuario);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Usuario modificado correctamente", "Usuario modificadp", 1);
	}

	public static void eliminarUsuario(JComboBox usuarioscomboBox, JComboBox rolcomboBox) throws SQLException {
		String usuario = usuarioscomboBox.getSelectedItem().toString();
		String rol = rolcomboBox.getSelectedItem().toString();

		Statement consulta = conexionBBDD().createStatement();
		int resultado;

		PreparedStatement consultaprep = conexionBBDD().prepareStatement("DELETE FROM Users WHERE User = ?");
		consultaprep.setString(1, usuario);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "El usuario" + usuario + " se ha eliminado de la base de datos",
				"Usuario eliminado", 1);
	}

	public static boolean comprobarRol(JTextField textRol) throws SQLException {
		String Rol = textRol.getText();

		Statement consulta = conexionBBDD().createStatement();
		ResultSet resultado;
		// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR EL USUARIO ESPECIFICO
		PreparedStatement consultaprep = conexionBBDD().prepareStatement("SELECT * FROM users WHERE user = ?");
		consultaprep.setString(1, Rol);
		resultado = consultaprep.executeQuery();

		if (resultado.next()) {
			if (resultado.getString("rol").equals("Admin")) {
				return true;
			}
		}
		return false;
	}
}
