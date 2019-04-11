package Controladores.Coches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controladores.conexion;

public class borrar {
	/***
	 * METODO PARA BORRAR UN COCHE
	 * @param textMatricula
	 * @throws SQLException
	 */
	public static void borrar(JTextField textMatricula) throws SQLException {
		String matricula = textMatricula.getText();
		Statement consulta = conexion.conexionBBDD().createStatement();
		int resultado;
		PreparedStatement consultaprep = conexion.conexionBBDD().prepareStatement("DELETE FROM coches WHERE Matricula = ?");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se han borrado todos los datos de la matricula "+matricula+" de la base de datos.");
	}
}
