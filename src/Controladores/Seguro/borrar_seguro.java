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

public class borrar_seguro {
	/**
	 * METODO PARA BORRAR EL MIEMBRO DEL SEGURO
	 * @param textMatricula
	 * @param comboBoxMiembro
	 * @throws SQLException
	 */
	public static void borrar(JTextField textMatricula, JComboBox comboBoxMiembro) throws SQLException {
		String matricula = textMatricula.getText();
		
		
		if(!matricula.equals("")) {
			if(comprobarMatricula.comprobarMatricula(textMatricula)) {
				try {
					String miembro = comboBoxMiembro.getSelectedItem().toString();
					String[] partes = miembro.split(" ");
					String nombre = partes[0];
					String apellido1 = partes[1];
					String apellido2 = partes[2];
					if(!miembro.equals("")) {
						Statement consulta = conexion.conexionBBDD().createStatement();
						int resultado;
						PreparedStatement consultaprep = conexion.conexionBBDD()
								.prepareStatement("DELETE FROM seguro WHERE nombre = ? AND apellido1 = ? AND apellido2 = ?");
						consultaprep.setString(1, nombre);
						consultaprep.setString(2, apellido1);
						consultaprep.setString(3, apellido2);
						resultado = consultaprep.executeUpdate();
						JOptionPane.showMessageDialog(null,
								"Se ha borrado del seguro al miembro:\n"+miembro);
					}else {
						JOptionPane.showMessageDialog(null,
								"Por favor, seleccione un miembro");
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,
							"Por favor, seleccione un miembro");
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null,
						"No existe la matricula "+matricula+" en la base de datos.");
			}
		}else {
			JOptionPane.showMessageDialog(null,
					"Por favor, ingrese una matricula.");
		}
		
		
	}

	/**
	 * METODO PARA RELLENAR EL COMBOBOX CON LOS MIEMBROS DEL SEGURO CON LA MATRICULA INDICADA
	 * @param textMatricula
	 * @param comboBoxMiembro
	 * @throws SQLException
	 */
	public static void obtenerMiembros(JTextField textMatricula, JComboBox comboBoxMiembro) throws SQLException {
		String matricula = textMatricula.getText();
		Statement consulta = conexion.conexionBBDD().createStatement();
		ResultSet resultado;
		PreparedStatement consultaprep = conexion.conexionBBDD().prepareStatement(
				"SELECT nombre, apellido1, apellido2 FROM seguro WHERE id_matricula = (SELECT id FROM coches WHERE matricula = ?)");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeQuery();
		while(resultado.next()) {
			comboBoxMiembro.addItem(resultado.getString("nombre")+" "+resultado.getString("apellido1")+" "+resultado.getString("apellido2"));
		}
		
	}
}
