package Controladores.Coches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Aplicacion.GestionCoches.Modificar;
import Aplicacion.GestionCoches.UpdateMatricula;
import Controladores.conexion;

public class modificar {
	

	/**
	 * 
	 * @param textMatricula
	 * @param marcacomboBox
	 * @param modelocomboBox
	 * @param textAno
	 * @param textKM
	 * @param textPrecio
	 * @throws SQLException
	 */
	public static void actualizar(JTextField textMatricula, JComboBox marcacomboBox, JComboBox modelocomboBox,
			JTextField textAno, JTextField textKM, JTextField textPrecio) throws SQLException {

		String matricula = textMatricula.getText();
		String marca = marcacomboBox.getSelectedItem().toString();
		String modelo = modelocomboBox.getSelectedItem().toString();
		String ano = textAno.getText();
		String kilometros = textKM.getText();
		String precio = textPrecio.getText();

		Statement consulta = conexion.conexionBBDD().createStatement();
		int resultado;

		PreparedStatement consultaprep = conexion.conexionBBDD().prepareStatement(
				"UPDATE Coches SET Matricula = ?, Marca = ?, Modelo = ?, Ano = ?, Precio = ?, KM = ? WHERE Matricula = ?");
		consultaprep.setString(1, matricula);
		consultaprep.setString(2, marca);
		consultaprep.setString(3, modelo);
		consultaprep.setString(4, ano);
		consultaprep.setString(5, precio);
		consultaprep.setString(6, kilometros);
		consultaprep.setString(7, matricula);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null, "Se han actualizado los cambios");
	}

	/**
	 * 
	 * @param textMatricula
	 * @param marcacomboBox
	 * @param modelocomboBox
	 * @param textAno
	 * @param textKM
	 * @param textPrecio
	 * @throws SQLException
	 */
	public static void recogerDatos(JTextField textMatricula, JComboBox marcacomboBox, JComboBox modelocomboBox,
			JTextField textAno, JTextField textKM, JTextField textPrecio) throws SQLException {

		String matricula = textMatricula.getText();

		Statement consulta = conexion.conexionBBDD().createStatement();
		ResultSet resultado;

		PreparedStatement consultaprep = conexion.conexionBBDD().prepareStatement("SELECT * FROM coches WHERE matricula = ?");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeQuery();
		if (resultado.next()) {
			// RECOGER MARCA

			for (int i = 0; i < marcacomboBox.getItemCount(); i++) {
				if (marcacomboBox.getItemAt(i).toString().equals(resultado.getString("Marca"))) {
					marcacomboBox.setSelectedItem(resultado.getObject("Marca"));
				}
			}
			// RECOGER MODELO
			modelocomboBox.setModel(
					new DefaultComboBoxModel(modeloCoche.getModelosAdd(marcacomboBox.getSelectedItem().toString())));
			for (int i = 0; i < modelocomboBox.getItemCount(); i++) {
				if (modelocomboBox.getItemAt(i).toString().equals(resultado.getString("Modelo"))) {
					modelocomboBox.setSelectedItem(resultado.getObject("Modelo"));
					break;

				}
			}
			// RECOGER AÑO

			textAno.setText(resultado.getString("Ano"));
			// RECOGER KILOMETROS

			textKM.setText(resultado.getString("km"));
			// RECOGER PRECIO

			textPrecio.setText(resultado.getString("precio"));
		}

	}

	/**
	 * 
	 * @param textMatricula
	 * @throws SQLException
	 */
	public static boolean comprobarMatricula(JTextField textMatricula) throws SQLException {
		String matricula = textMatricula.getText();

		Statement consulta = conexion.conexionBBDD().createStatement();
		ResultSet resultado;

		PreparedStatement consultaprep = conexion.conexionBBDD().prepareStatement("SELECT * FROM coches WHERE matricula = ?");
		consultaprep.setString(1, matricula);
		resultado = consultaprep.executeQuery();
		if (resultado.next()) {
			return true;

		} else {
			return false;
		}
	}
}
