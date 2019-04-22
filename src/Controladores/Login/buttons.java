package Controladores.Login;


import java.awt.Color;
import java.awt.Font;
import java.nio.channels.ShutdownChannelGroupException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import Aplicacion.MenuTiendaAdmin;
import Controladores.conexion;
import login.Login;

public class buttons {

	/**
	 * METODO QUE CONTROLA EL BOTON DE LOGIN PARA ACCEDER A LA APLICACION
	 * 
	 * @param textUser
	 * @param textPassword
	 * @return
	 * @throws SQLException
	 */
	public static boolean buttonLogin(JTextField textUser, JTextField textPassword) throws SQLException {

		String usuario = textUser.getText();
		String pass = textPassword.getText();

		Statement consulta = conexion.conexionBBDD().createStatement();
		ResultSet resultado;
		// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR EL USUARIO ESPECIFICO
		PreparedStatement consultaprep = conexion.conexionBBDD().prepareStatement("SELECT * FROM users WHERE user = ?");
		consultaprep.setString(1, usuario);
		resultado = consultaprep.executeQuery();

		if (resultado.next()) {
			// VERIFICACION DEL USUARIO
			if (resultado.getString("user").equals(usuario)) {

				// VERIFICACION DE CONTRASEÑA UNA VEZ EL USUARIO ES CORRECTO
				if (resultado.getString("password").equals(pass)) {
					if (resultado.getString("rol").equals("Admin")) {
						JOptionPane.showMessageDialog(null, " Logeado correctamente con rol de Administrador");
						JLabel labelRol = new JLabel(); 
						labelRol.setBounds(276, 21, 185, 49);
						labelRol.setForeground(Color.WHITE);
						labelRol.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
						labelRol.setText("Administrador");
						labelRol.setVisible(true);
						MenuTiendaAdmin.setLabelRol(labelRol);
						MenuTiendaAdmin.main(null);
					} else {
						JOptionPane.showMessageDialog(null, " Logeado correctamente");
						JLabel labelRol = new JLabel(); 
						labelRol.setBounds(276, 21, 185, 49);
						labelRol.setForeground(Color.WHITE);
						labelRol.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
						labelRol.setText("Usuario");
						labelRol.setVisible(true);
						MenuTiendaAdmin.setLabelRol(labelRol);
						MenuTiendaAdmin.main(null);

						
					}
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

	/**
	 * METODO QUE CONTROLA EL BOTON REGISTER Y AÑADE UN USUARIO
	 * 
	 * @param textUser
	 * @param textPassword
	 * @throws SQLException
	 */
	public static void buttonRegister(JTextField textUser, JTextField textPassword) throws SQLException {
		String usuario = textUser.getText();
		String password = textPassword.getText();
		
		comprobarUsuario comprobar = new comprobarUsuario();
		if(!comprobar.comprobarUsuario(usuario)) {
			Statement consulta = conexion.conexionBBDD().createStatement();
			int resultado;
			PreparedStatement consultaprep = conexion.conexionBBDD()
					.prepareStatement("INSERT INTO users (user,password,rol) VALUES (?, ?, '')");
			consultaprep.setString(1, usuario);
			consultaprep.setString(2, password);
			resultado = consultaprep.executeUpdate();
			JOptionPane.showMessageDialog(null,
					"Se ha añadido el usuario " + usuario + " con contraseña " + password + " en la base de datos.");
		}else {
			JOptionPane.showMessageDialog(null, "El usuario ya existe.");
		}

		

	}

}
