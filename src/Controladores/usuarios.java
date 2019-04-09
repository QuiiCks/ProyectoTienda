package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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

		Statement consulta = conexionBBDDExterna.conexionBBDD().createStatement();
		ResultSet resultado;
		PreparedStatement consultaprep = conexionBBDDExterna.conexionBBDD().prepareStatement("SELECT user FROM users");
		resultado = consultaprep.executeQuery();
		while (resultado.next()) {
			usuarios.addItem(resultado.getObject(1));
		}
	}

	public static void actualizarUsuarios(JComboBox usuarioscomboBox, JComboBox rolcomboBox) throws SQLException {
		String usuario = usuarioscomboBox.getSelectedItem().toString();
		String rol = rolcomboBox.getSelectedItem().toString();

		Statement consulta = conexionBBDDExterna.conexionBBDD().createStatement();
		int resultado;
		
		PreparedStatement consultaprep = conexionBBDDExterna.conexionBBDD().prepareStatement(
				"UPDATE Users SET Rol = ? WHERE User = ?");
		consultaprep.setString(1, rol);
		consultaprep.setString(2, usuario);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Usuario modificado correctamente", "Usuario modificadp", 1);
	}
	public static void eliminarUsuario(JComboBox usuarioscomboBox, JComboBox rolcomboBox) throws SQLException {
		String usuario = usuarioscomboBox.getSelectedItem().toString();
		String rol = rolcomboBox.getSelectedItem().toString();

		Statement consulta = conexionBBDDExterna.conexionBBDD().createStatement();
		int resultado;
		
		PreparedStatement consultaprep = conexionBBDDExterna.conexionBBDD().prepareStatement(
				"DELETE FROM Users WHERE User = ?");
		consultaprep.setString(1, usuario);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "El usuario"+ usuario+" se ha eliminado de la base de datos", "Usuario eliminado", 1);
	}
}
