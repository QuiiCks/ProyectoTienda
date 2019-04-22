package Controladores.Seguro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controladores.conexion;
import Controladores.Coches.comprobarMatricula;

public class anadir_seguro {
	conexion con = new conexion();
	/**
	 * METODO PARA AÑADIR AL SEGURO LOS CAMPOS INDICADOS
	 * @param textMatricula
	 * @param textNombre
	 * @param textApellido1
	 * @param textApellido2
	 * @param textEmail
	 * @throws SQLException
	 */
	public void anadiSeguro(JTextField textMatricula, JTextField textNombre, JTextField textApellido1,
			JTextField textApellido2, JTextField textEmail) throws SQLException {
		String matricula = textMatricula.getText();
		String nombre = textNombre.getText();
		String apellido1 = textApellido1.getText();
		String apellido2 = textApellido2.getText();
		String email = textEmail.getText();

		Statement consulta = con.conexionBBDD().createStatement();
		int resultado;
		comprobarMatricula controlador = new comprobarMatricula();
		if(controlador.comprobarMatricula(textMatricula)) {
			if(!nombre.equals("") && !apellido1.equals("") && !apellido2.equals("") && !email.equals("")) {
				PreparedStatement consultaprep = con.conexionBBDD()
						.prepareStatement("INSERT INTO seguro(id_matricula, Nombre, Apellido1, Apellido2, email) VALUES ("
								+ "(SELECT id FROM coches WHERE matricula = ?),?,?,?,?)");
				consultaprep.setString(1, matricula);
				consultaprep.setString(2, nombre);
				consultaprep.setString(3, apellido1);
				consultaprep.setString(4, apellido2);
				consultaprep.setString(5, email);
				resultado = consultaprep.executeUpdate();
				JOptionPane.showMessageDialog(null,
						"Se han incluido los siguientes datos en el seguro\nMatricula: " + matricula + "\nNombre: "
								+ nombre + "\nApellido: " + apellido1+" "+apellido2 + "\nDireccion de correo: " + email);
			}else {
				JOptionPane.showMessageDialog(null,
						"Por favor, rellene todos los campos.");
			}
			
		}else {
			JOptionPane.showMessageDialog(null,
					"No existe la matricula "+matricula+" en la base de datos.");
		}

		
	}
	
}
