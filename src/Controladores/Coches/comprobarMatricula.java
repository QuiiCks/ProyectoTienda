package Controladores.Coches;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

import Controladores.conexion;
/**
 * 
 * @author Javi
 *
 */
public class comprobarMatricula {
	public static boolean comprobarMatricula(JTextField textMatricula) throws SQLException {
		String matricula = textMatricula.getText();
		
		Statement consulta = conexion.conexionBBDD().createStatement();
		ResultSet resultado;

		PreparedStatement consultaprep = conexion.conexionBBDD()
				.prepareStatement("SELECT matricula FROM coches WHERE matricula = ?");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeQuery();
		if(resultado.next()) {
			return true;
		}
		return false;
	}
}
