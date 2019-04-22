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

public class anadir {
	conexion con = new conexion();
	/**
	 * METODO PARA AÑADIR UN COCHE
	 * @param marcacomboBox
	 * @param modelocomboBox
	 * @param textAno
	 * @param textKM
	 * @param textPrecio
	 * @param textMatricula
	 * @throws SQLException
	 */
	public void anadir(JComboBox marcacomboBox, JComboBox modelocomboBox, JTextField textAno, JTextField textKM,
			JTextField textPrecio, JTextField textMatricula) throws SQLException {
		String marca = marcacomboBox.getSelectedItem().toString();
		String modelo = modelocomboBox.getSelectedItem().toString();
		String ano = textAno.getText();
		String kilometros = textKM.getText();
		String precio = textPrecio.getText();
		String matricula = textMatricula.getText();

		Statement consulta = con.conexionBBDD().createStatement();
		int resultado;

		PreparedStatement consultaprep = con.conexionBBDD().prepareStatement("INSERT INTO coches(Matricula, Marca, Modelo, Ano, Precio, KM) VALUES (?,?,?,?,?,?)");
		consultaprep.setString(1, matricula);
		consultaprep.setString(2, marca);
		consultaprep.setString(3, modelo);
		consultaprep.setString(4, ano);
		consultaprep.setString(5, precio);
		consultaprep.setString(6, kilometros);
		resultado = consultaprep.executeUpdate();
		JOptionPane.showMessageDialog(null,
				"Se han incluido los siguientes datos en la base de datos\nMatricula: " + matricula + "\nMarca: "
						+ marca + "\nModelo: " + modelo + "\nAño: " + ano + "\nKilometros: " + kilometros + "\nPrecio: "
						+ precio);
	}
}
