package Controladores.Login;

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
import Controladores.conexion;

public class usuarios {
	conexion con = new conexion();

	/**
	 * RELLENA EL COMBOBOX CON LOS USUARIOS REGISTRADOS
	 * @param usuarios
	 * @throws SQLException
	 */
	public void obtenerUsuarios(JComboBox usuarios) throws SQLException {

		Statement consulta = con.conexionBBDD().createStatement();
		ResultSet resultado;
		PreparedStatement consultaprep = con.conexionBBDD().prepareStatement("SELECT user FROM users");
		resultado = consultaprep.executeQuery();
		while (resultado.next()) {
			usuarios.addItem(resultado.getObject(1));
		}
	}

	/**
	 * SE ACTUALIZAN LOS PERMISOS DE UN USUARIO
	 * @param usuarioscomboBox
	 * @param rolcomboBox
	 * @throws SQLException
	 */
	public  void actualizarUsuarios(JComboBox usuarioscomboBox, JComboBox rolcomboBox) throws SQLException {
		String usuario = usuarioscomboBox.getSelectedItem().toString();
		String rol = rolcomboBox.getSelectedItem().toString();

		Statement consulta = con.conexionBBDD().createStatement();
		int resultado;

		PreparedStatement consultaprep = con.conexionBBDD().prepareStatement("UPDATE Users SET Rol = ? WHERE User = ?");
		consultaprep.setString(1, rol);
		consultaprep.setString(2, usuario);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Usuario modificado correctamente", "Usuario modificadp", 1);
	}

	/**
	 * SE ELIMINA UN USUARIO DE LA BASE DE DATOS
	 * @param usuarioscomboBox
	 * @param rolcomboBox
	 * @throws SQLException
	 */
	public  void eliminarUsuario(JComboBox usuarioscomboBox, JComboBox rolcomboBox) throws SQLException {
		String usuario = usuarioscomboBox.getSelectedItem().toString();
		String rol = rolcomboBox.getSelectedItem().toString();

		Statement consulta = con.conexionBBDD().createStatement();
		int resultado;

		PreparedStatement consultaprep = con.conexionBBDD().prepareStatement("DELETE FROM Users WHERE User = ?");
		consultaprep.setString(1, usuario);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "El usuario" + usuario + " se ha eliminado de la base de datos",
				"Usuario eliminado", 1);
	}

	/**
	 * SE COMPRUEBA SI EL USUARIO ES ADMINISTRADOR
	 * @param textRol
	 * @return
	 * @throws SQLException
	 */
	public  boolean comprobarRol(JTextField textRol) throws SQLException {
		String Rol = textRol.getText();

		Statement consulta = con.conexionBBDD().createStatement();
		ResultSet resultado;
		// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR EL USUARIO ESPECIFICO
		PreparedStatement consultaprep = con.conexionBBDD().prepareStatement("SELECT * FROM users WHERE user = ?");
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
