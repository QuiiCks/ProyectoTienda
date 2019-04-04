package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.anadir;
import Controladores.modeloCoche;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Anadir extends JFrame {

	private JPanel contentPane;
	private JTextField textAno;
	private JTextField textKM;
	private JTextField textPrecio;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anadir frame = new Anadir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Anadir() {
		setTitle("JaShop - A\u00F1adir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(127, 255, 212));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAadirCoche = new JLabel("A\u00F1adir coche");
		lblAadirCoche.setForeground(Color.WHITE);
		lblAadirCoche.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblAadirCoche.setBounds(10, 11, 215, 49);
		contentPane.add(lblAadirCoche);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMatricula.setBounds(10, 71, 78, 26);
		contentPane.add(lblMatricula);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMarca.setBounds(10, 128, 52, 26);
		contentPane.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblModelo.setBounds(260, 128, 85, 26);
		contentPane.add(lblModelo);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAo.setBounds(10, 179, 38, 26);
		contentPane.add(lblAo);

		JLabel lblKilometros = new JLabel("Kilometros");
		lblKilometros.setFont(new Font("Calibri", Font.BOLD, 18));
		lblKilometros.setBounds(260, 179, 85, 26);
		contentPane.add(lblKilometros);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPrecio.setBounds(10, 216, 52, 26);
		contentPane.add(lblPrecio);

		textAno = new JTextField();
		textAno.setFont(new Font("Calibri", Font.BOLD, 18));
		textAno.setColumns(10);
		textAno.setBounds(49, 179, 100, 26);
		contentPane.add(textAno);

		textKM = new JTextField();
		textKM.setFont(new Font("Calibri", Font.BOLD, 18));
		textKM.setColumns(10);
		textKM.setBounds(354, 179, 100, 26);
		contentPane.add(textKM);

		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Calibri", Font.BOLD, 18));
		textPrecio.setColumns(10);
		textPrecio.setBounds(59, 216, 100, 26);
		contentPane.add(textPrecio);

		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(169, 216, 24, 26);
		contentPane.add(label);

		JComboBox marcacomboBox = new JComboBox();
		marcacomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		marcacomboBox.setBounds(72, 124, 131, 30);
		contentPane.add(marcacomboBox);
		marcacomboBox.addItem("");
		marcacomboBox.addItem("Seat");
		marcacomboBox.addItem("Opel");
		marcacomboBox.addItem("Ford");
		marcacomboBox.addItem("Renault");
		marcacomboBox.addItem("Chevrolet");

		JComboBox modelocomboBox = new JComboBox();
		modelocomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		modelocomboBox.setBounds(332, 124, 131, 30);
		contentPane.add(modelocomboBox);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(98, 71, 100, 26);
		contentPane.add(textMatricula);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					anadir.anadir(marcacomboBox, modelocomboBox, textAno, textKM, textPrecio, textMatricula);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAadir.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAadir.setBackground(Color.LIGHT_GRAY);
		btnAadir.setBounds(259, 28, 156, 36);
		contentPane.add(btnAadir);
		
		JButton button = new JButton("Volver al menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuTienda.main(null);
				setVisible(false);
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(260, 74, 155, 36);
		contentPane.add(button);

		// Listener para controlar ambos comboBox
		String marca = (String) marcacomboBox.getSelectedItem();
		marcacomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				// Verificamos si hay un cambio de seleccion
				if (event.getStateChange() == ItemEvent.SELECTED) {
					// Verificamos que el item seleccionado sea distinto a 0, que es el
					// predeterminado
					if (marcacomboBox.getSelectedIndex() > 0) {
						modelocomboBox.setModel(new DefaultComboBoxModel(
								modeloCoche.getModelosAdd(marcacomboBox.getSelectedItem().toString())));
					}
				}
			}
		});
	}
}
