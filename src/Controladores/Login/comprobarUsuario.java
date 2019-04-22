package Controladores.Login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controladores.conexion;

public class comprobarUsuario {
	conexion con = new conexion();
	public boolean comprobarUsuario(String usuario) throws SQLException {
		Statement consulta = con.conexionBBDD().createStatement();
		ResultSet resultado;
		// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR EL USUARIO ESPECIFICO
		PreparedStatement consultaprep = con.conexionBBDD().prepareStatement("SELECT * FROM users WHERE user = ?");
		consultaprep.setString(1, usuario);
		resultado = consultaprep.executeQuery();
		if (resultado.next()) {
			return true;
		}
		return false;
	}
}
