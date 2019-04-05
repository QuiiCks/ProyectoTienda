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
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Anadir.class.getResource("/recursos/Logo.png")));
		setTitle("JaShop - A\u00F1adir");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAadirCoche = new JLabel("A\u00F1adir coche");
		lblAadirCoche.setForeground(Color.WHITE);
		lblAadirCoche.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblAadirCoche.setBounds(29, 0, 215, 49);
		contentPane.add(lblAadirCoche);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMatricula.setBounds(20, 97, 78, 26);
		contentPane.add(lblMatricula);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMarca.setBounds(20, 58, 52, 26);
		contentPane.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblModelo.setBounds(238, 58, 85, 26);
		contentPane.add(lblModelo);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAo.setBounds(24, 134, 38, 26);
		contentPane.add(lblAo);

		JLabel lblKilometros = new JLabel("Kilometros");
		lblKilometros.setFont(new Font("Calibri", Font.BOLD, 18));
		lblKilometros.setBounds(238, 97, 85, 26);
		contentPane.add(lblKilometros);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPrecio.setBounds(238, 134, 52, 26);
		contentPane.add(lblPrecio);

		textAno = new JTextField();
		textAno.setFont(new Font("Calibri", Font.BOLD, 18));
		textAno.setColumns(10);
		textAno.setBounds(104, 134, 100, 26);
		contentPane.add(textAno);

		textKM = new JTextField();
		textKM.setFont(new Font("Calibri", Font.BOLD, 18));
		textKM.setColumns(10);
		textKM.setBounds(333, 97, 100, 26);
		contentPane.add(textKM);

		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Calibri", Font.BOLD, 18));
		textPrecio.setColumns(10);
		textPrecio.setBounds(333, 134, 100, 26);
		contentPane.add(textPrecio);

		JLabel label = new JLabel("\u20AC");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(443, 134, 24, 26);
		contentPane.add(label);

		JComboBox marcacomboBox = new JComboBox();
		marcacomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		marcacomboBox.setBounds(104, 56, 100, 30);
		contentPane.add(marcacomboBox);
		marcacomboBox.addItem("");
		marcacomboBox.addItem("Seat");
		marcacomboBox.addItem("Opel");
		marcacomboBox.addItem("Ford");
		marcacomboBox.addItem("Renault");
		marcacomboBox.addItem("Chevrolet");

		JComboBox modelocomboBox = new JComboBox();
		modelocomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		modelocomboBox.setBounds(333, 56, 100, 30);
		contentPane.add(modelocomboBox);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(104, 97, 100, 26);
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
		btnAadir.setBounds(10, 181, 156, 36);
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
		button.setBounds(182, 181, 155, 36);
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
