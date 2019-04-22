package Controladores.Seguro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controladores.conexion;

public class listar_seguro {
	conexion con = new conexion();
	/**
	 * METODO PARA LISTAR LOS MIEMBROS DE LA MATRICULA INDICADA
	 * @param textMatricula
	 * @param tablaConsulta
	 * @throws SQLException
	 */
	public  void listarMiembros(JTextField textMatricula, JTable tablaConsulta) throws SQLException {
		String matricula = textMatricula.getText();
		boolean registros = false;
		Statement consulta = con.conexionBBDD().createStatement();
		ResultSet resultado;

		if (!matricula.equals("")) {
			limpiarTabla(tablaConsulta);

			PreparedStatement consultaprep = con.conexionBBDD()
					.prepareStatement("SELECT * FROM seguro WHERE id_matricula = (SELECT id FROM coches WHERE matricula = ?)");
			consultaprep.setString(1, matricula);
			resultado = consultaprep.executeQuery();
			int row = 0, col = 0;
			
			while (resultado.next()) {
				registros = true;
				tablaConsulta.setValueAt(matricula, row, 0);
				tablaConsulta.setValueAt(resultado.getString("Nombre"), row, 1);
				tablaConsulta.setValueAt(resultado.getString("apellido1"), row, 2);
				tablaConsulta.setValueAt(resultado.getString("apellido2"), row, 3);
				tablaConsulta.setValueAt(resultado.getString("email"), row, 4);
				row++;
			}
			if(!registros) {
				JOptionPane.showMessageDialog(null, "No hay registros para la matricula "+matricula);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Introduzca una matricula");
		}
	}
	/**
	 * METODO PARA LIMPIAR LA TABLA AL FILTRAR DE NUEVO
	 * @param tablaConsultas
	 */
	public  void limpiarTabla(JTable tablaConsultas) {
		Object titulos [] = {"Matricula", "Nombre", "Primer apellido", "Segundo apellido", "Direccion de correo"};
		Object celdas [][] = new Object [50][5];
		
		tablaConsultas.setModel(new DefaultTableModel(celdas, titulos));
	}
}
