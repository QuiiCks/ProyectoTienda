package Aplicacion.GestionCoches;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.MenuTiendaAdmin;
import Controladores.Coches.modificar;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class UpdateMatricula extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		UpdateMatricula frame = new UpdateMatricula();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public UpdateMatricula() {
		setResizable(false);
		setTitle("JaShop - Matricula");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateMatricula.class.getResource("/recursos/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 192);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblModificarProductos = new JLabel("Modificar productos");
		lblModificarProductos.setForeground(Color.WHITE);
		lblModificarProductos.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblModificarProductos.setBounds(10, 0, 276, 49);
		contentPane.add(lblModificarProductos);

		JLabel lblInsertaLaMatricula = new JLabel("Inserta la matricula a modificar");
		lblInsertaLaMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		lblInsertaLaMatricula.setBounds(10, 48, 245, 26);
		contentPane.add(lblInsertaLaMatricula);

		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(10, 74, 156, 26);
		contentPane.add(textMatricula);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String matricula = textMatricula.getText();
					Pattern patmatricula = Pattern.compile("([0-9]{4})([A-Z]{3})");
					Matcher matmatricula = patmatricula.matcher(matricula);
					if (matmatricula.find()) {
						modificar modificarcon = new modificar();
						if (modificarcon.comprobarMatricula(textMatricula)) {
							Modificar.main(null);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Matricula no encontrada en la base de datos",
									"Error matricula", 1);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"El campo matricula tiene que contener el formato europeo.\nFormato europeo: 1234ABC");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FileWriter writer;
				try {
					writer = new FileWriter("src/controladores/matricula.txt");
					writer.write(textMatricula.getText());
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnContinuar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnContinuar.setBackground(Color.LIGHT_GRAY);
		btnContinuar.setBounds(10, 108, 210, 36);
		contentPane.add(btnContinuar);

		JButton button = new JButton("Volver al menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTiendaAdmin.main(null);
				setVisible(false);
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(230, 108, 155, 36);
		contentPane.add(button);
	}
}
