package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Aplicacion.Listar;

public class filtrar {
	/**
	 * METODO PARA CONECTAR CON LA BASE DE DATOS
	 * @return
	 * @throws SQLException
	 */
	public static Connection conexionBBDD() throws SQLException {
		// CONEXION CON LA BASE DE DATOS
		String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String dbName = "ProyectoTienda";
		String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;
		String user = "root";
		String password = "manolo";

		Connection conexion = DriverManager.getConnection(url, user, password);
		return conexion;
	}
	/**
	 * METODO PARA FILTRAR LOS VEHICULOS
	 * @param marcacomboBox
	 * @param modelocomboBox
	 * @param textAno
	 * @param textKM0
	 * @param textKM1
	 * @param tablaConsultas
	 * @throws SQLException
	 */
	public static void filtrar(JComboBox marcacomboBox, JComboBox modelocomboBox, JTextField textAno,
			JTextField textKM0, JTextField textKM1, JTable tablaConsultas) throws SQLException {

		String marca = marcacomboBox.getSelectedItem().toString();
		String modelo = modelocomboBox.getSelectedItem().toString();
		String ano = textAno.getText();
		String kilometro1 = textKM0.getText();
		String kilometro2 = textKM1.getText();

		Statement consulta = conexionBBDD().createStatement();
		ResultSet resultado;

		
		/**
		 * FILTRO PARA MOSTRAR TODOS LOS VEHICULOS
		 */
		if (marca.equals("Cualquiera") && ano.equals("")) {
			limpiarTabla(tablaConsultas);

			PreparedStatement consultaprep = conexionBBDD().prepareStatement("SELECT * FROM coches WHERE KM >=? AND KM <= ?");
			consultaprep.setString(1, kilometro1);
			consultaprep.setString(2, kilometro2);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			while (resultado.next()) {
				tablaConsultas.setValueAt(resultado.getString("Matricula"), row, 0);
				tablaConsultas.setValueAt(resultado.getString("Marca"), row, 1);
				tablaConsultas.setValueAt(resultado.getString("Modelo"), row, 2);
				tablaConsultas.setValueAt(resultado.getString("Ano"), row, 3);
				tablaConsultas.setValueAt(resultado.getString("KM"), row, 4);
				tablaConsultas.setValueAt(resultado.getString("Precio"), row, 5);
				row++;
			}
		}

		/**
		 * FILTRO PARA MOSTRAR TODOS LOS VEHICULOS DE UNA MARCA
		 */
		if (!marca.equals("Cualquiera")) {
			limpiarTabla(tablaConsultas);
			// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR SEGUN LOS FILTROS INDICADOS
			PreparedStatement consultaprep = conexionBBDD().prepareStatement("SELECT * FROM coches WHERE marca = ? AND KM >=? AND KM <= ?");
			consultaprep.setString(1, marca);
			consultaprep.setString(2, kilometro1);
			consultaprep.setString(3, kilometro2);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			while (resultado.next()) {
				tablaConsultas.setValueAt(resultado.getString("Matricula"), row, 0);
				tablaConsultas.setValueAt(resultado.getString("Marca"), row, 1);
				tablaConsultas.setValueAt(resultado.getString("Modelo"), row, 2);
				tablaConsultas.setValueAt(resultado.getString("Ano"), row, 3);
				tablaConsultas.setValueAt(resultado.getString("KM"), row, 4);
				tablaConsultas.setValueAt(resultado.getString("Precio"), row, 5);
				row++;
			}
		}
		/**
		 * FILTRO PARA MOSTRAR EL MODELO ESPECIFICO DE UNA MARCA ESPECIFICA
		 */
		if (!marca.equals("Cualquiera") && !modelo.equals("Cualquiera")) {
			limpiarTabla(tablaConsultas);
			
			// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR SEGUN LOS FILTROS INDICADOS
			PreparedStatement consultaprep = conexionBBDD()
					.prepareStatement("SELECT * FROM coches WHERE marca = ? AND modelo = ? AND KM >=? AND KM <= ?");
			consultaprep.setString(1, marca);
			consultaprep.setString(2, modelo);
			consultaprep.setString(3, kilometro1);
			consultaprep.setString(4, kilometro2);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			while (resultado.next()) {
				tablaConsultas.setValueAt(resultado.getString("Matricula"), row, 0);
				tablaConsultas.setValueAt(resultado.getString("Marca"), row, 1);
				tablaConsultas.setValueAt(resultado.getString("Modelo"), row, 2);
				tablaConsultas.setValueAt(resultado.getString("Ano"), row, 3);
				tablaConsultas.setValueAt(resultado.getString("KM"), row, 4);
				tablaConsultas.setValueAt(resultado.getString("Precio"), row, 5);
				row++;
			}
		}
		
		/**
		 * FILTRO PARA MOSTRAR TODOS LOS COCHES DE UN AÑO ESPECIFICO
		 */
		if (marca.equals("Cualquiera") && modelo.equals("Cualquiera") && !ano.equals("")) {
			limpiarTabla(tablaConsultas);
			// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR SEGUN LOS FILTROS INDICADOS
			PreparedStatement consultaprep = conexionBBDD()
					.prepareStatement("SELECT * FROM coches WHERE ano = ? AND KM >=? AND KM <= ?");
			consultaprep.setString(1, ano);
			consultaprep.setString(2, kilometro1);
			consultaprep.setString(3, kilometro2);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			while (resultado.next()) {
				tablaConsultas.setValueAt(resultado.getString("Matricula"), row, 0);
				tablaConsultas.setValueAt(resultado.getString("Marca"), row, 1);
				tablaConsultas.setValueAt(resultado.getString("Modelo"), row, 2);
				tablaConsultas.setValueAt(resultado.getString("Ano"), row, 3);
				tablaConsultas.setValueAt(resultado.getString("KM"), row, 4);
				tablaConsultas.setValueAt(resultado.getString("Precio"), row, 5);
				row++;
			}
		}
		
		/**
		 * FILTRO PARA MOSTRAR LOS VEHICULOS DE UNA MARCA EN UN AÑO ESPECIFICO
		 */
		if (!marca.equals("Cualquiera") && !ano.equals("")) {
			limpiarTabla(tablaConsultas);
			// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR SEGUN LOS FILTROS INDICADOS
			PreparedStatement consultaprep = conexionBBDD()
					.prepareStatement("SELECT * FROM coches WHERE marca = ? AND ano = ? AND KM >=? AND KM <= ?");
			consultaprep.setString(1, marca);
			consultaprep.setString(2, ano);
			consultaprep.setString(3, kilometro1);
			consultaprep.setString(4, kilometro2);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			while (resultado.next()) {
				tablaConsultas.setValueAt(resultado.getString("Matricula"), row, 0);
				tablaConsultas.setValueAt(resultado.getString("Marca"), row, 1);
				tablaConsultas.setValueAt(resultado.getString("Modelo"), row, 2);
				tablaConsultas.setValueAt(resultado.getString("Ano"), row, 3);
				tablaConsultas.setValueAt(resultado.getString("KM"), row, 4);
				tablaConsultas.setValueAt(resultado.getString("Precio"), row, 5);
				row++;
			}
		}
		/**
		 * FILTRO PARA MOSTRAR LOS MODELOS DE UNA MARCAR EN UN AÑO ESPECIFICO
		 */
		if (!marca.equals("Cualquiera") && !modelo.equals("Cualquiera")&&!ano.equals("")) {
			limpiarTabla(tablaConsultas);
			// CREAMOS UNA CONSULTA PREPARADA PARA BUSCAR SEGUN LOS FILTROS INDICADOS
			PreparedStatement consultaprep = conexionBBDD()
					.prepareStatement("SELECT * FROM coches WHERE marca = ? AND modelo = ? AND ano = ? AND KM >=? AND KM <= ?");
			consultaprep.setString(1, marca);
			consultaprep.setString(2, modelo);
			consultaprep.setString(3, ano);
			consultaprep.setString(4, kilometro1);
			consultaprep.setString(5, kilometro2);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			while (resultado.next()) {
				tablaConsultas.setValueAt(resultado.getString("Matricula"), row, 0);
				tablaConsultas.setValueAt(resultado.getString("Marca"), row, 1);
				tablaConsultas.setValueAt(resultado.getString("Modelo"), row, 2);
				tablaConsultas.setValueAt(resultado.getString("Ano"), row, 3);
				tablaConsultas.setValueAt(resultado.getString("KM"), row, 4);
				tablaConsultas.setValueAt(resultado.getString("Precio"), row, 5);
				row++;
			}
		}
	}
	/**
	 * METODO PARA LIMPIAR LA TABLA ANTES DE CADA CONSULTA
	 * @param tablaConsultas
	 */
	public static void limpiarTabla(JTable tablaConsultas) {
		Object titulos [] = {"Matricula", "Marca", "Modelo", "Año", "KM", "Precio"};
		Object celdas [][] = new Object [50][6];
		
		tablaConsultas.setModel(new DefaultTableModel(celdas, titulos));
	}
}
