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
	conexion con = new conexion();
	public  boolean comprobarMatricula(JTextField textMatricula) throws SQLException {
		String matricula = textMatricula.getText();
		
		Statement consulta = con.conexionBBDD().createStatement();
		ResultSet resultado;

		PreparedStatement consultaprep = con.conexionBBDD()
				.prepareStatement("SELECT matricula FROM coches WHERE matricula = ?");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeQuery();
		if(resultado.next()) {
			return true;
		}
		return false;
	}
}
