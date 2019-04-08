package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.modeloCoche;
import Controladores.modificar;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modificar extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textKilometros;
	private JTextField textAno;
	private JTextField textPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar frame = new Modificar();
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
	public Modificar() {
		setTitle("JaShop - Modificar Producto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modificar.class.getResource("/recursos/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Modificar productos");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		label.setBounds(10, 11, 276, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Marca");
		label_1.setFont(new Font("Calibri", Font.BOLD, 18));
		label_1.setBounds(10, 61, 52, 26);
		contentPane.add(label_1);
		
		
		JComboBox marcacomboBox = new JComboBox();
		marcacomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		marcacomboBox.setBounds(65, 57, 100, 30);
		contentPane.add(marcacomboBox);
		
		marcacomboBox.addItem("Seat");
		marcacomboBox.addItem("Opel");
		marcacomboBox.addItem("Ford");
		marcacomboBox.addItem("Renault");
		marcacomboBox.addItem("Chevrolet");
		
		JLabel label_2 = new JLabel("Modelo");
		label_2.setFont(new Font("Calibri", Font.BOLD, 18));
		label_2.setBounds(170, 61, 85, 26);
		contentPane.add(label_2);
		
		JComboBox modelocomboBox = new JComboBox();
		modelocomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		modelocomboBox.setBounds(236, 57, 100, 30);
		contentPane.add(modelocomboBox);
		// Listener para controlar ambos comboBox
		marcacomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				// Verificamos si hay un cambio de seleccion
				if (event.getStateChange() == ItemEvent.SELECTED) {
						modelocomboBox.setModel(new DefaultComboBoxModel(
								modeloCoche.getModelosAdd(marcacomboBox.getSelectedItem().toString())));
					
				}
			}
		});
		
		JLabel label_3 = new JLabel("Matricula");
		label_3.setFont(new Font("Calibri", Font.BOLD, 18));
		label_3.setBounds(10, 98, 78, 26);
		contentPane.add(label_3);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(92, 98, 100, 26);
		contentPane.add(textMatricula);
		
		JLabel label_4 = new JLabel("Kilometros");
		label_4.setFont(new Font("Calibri", Font.BOLD, 18));
		label_4.setBounds(201, 98, 85, 26);
		contentPane.add(label_4);
		
		textKilometros = new JTextField();
		textKilometros.setFont(new Font("Calibri", Font.BOLD, 18));
		textKilometros.setColumns(10);
		textKilometros.setBounds(287, 98, 100, 26);
		contentPane.add(textKilometros);
		
		JLabel label_5 = new JLabel("A\u00F1o");
		label_5.setFont(new Font("Calibri", Font.BOLD, 18));
		label_5.setBounds(10, 135, 38, 26);
		contentPane.add(label_5);
		
		textAno = new JTextField();
		textAno.setFont(new Font("Calibri", Font.BOLD, 18));
		textAno.setColumns(10);
		textAno.setBounds(49, 135, 100, 26);
		contentPane.add(textAno);
		
		JLabel label_6 = new JLabel("Precio");
		label_6.setFont(new Font("Calibri", Font.BOLD, 18));
		label_6.setBounds(159, 135, 52, 26);
		contentPane.add(label_6);
		
		textPrecio = new JTextField();
		textPrecio.setFont(new Font("Calibri", Font.BOLD, 18));
		textPrecio.setColumns(10);
		textPrecio.setBounds(211, 135, 100, 26);
		contentPane.add(textPrecio);
		
		JLabel label_7 = new JLabel("\u20AC");
		label_7.setFont(new Font("Calibri", Font.BOLD, 18));
		label_7.setBounds(312, 135, 24, 26);
		contentPane.add(label_7);
		
		JButton btnActualizar = new JButton("Actualizar");
		
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnActualizar.setBackground(Color.LIGHT_GRAY);
		btnActualizar.setBounds(9, 168, 156, 36);
		contentPane.add(btnActualizar);
		
		JButton button_1 = new JButton("Volver al menu");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuTiendaAdmin.main(null);
				setVisible(false);
			}
		});
		button_1.setFont(new Font("Calibri", Font.BOLD, 18));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(170, 168, 155, 36);
		contentPane.add(button_1);
		
		
		//ALMACENAMOS LA MATRICULA EN UN FICHERO
		String ruta = "src/controladores/matricula.txt";
		File fichero = new File(ruta);
		Scanner teclado;
		try {
			teclado = new Scanner(fichero);
			while (teclado.hasNext()) {
				String data = teclado.nextLine();
				textMatricula.setText(data);
			}
			teclado.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//RECOGEMOS LOS DATOS
		try {
			modificar.recogerDatos(textMatricula, marcacomboBox, modelocomboBox, textAno, textKilometros, textPrecio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(modelocomboBox.getSelectedItem().toString().equals(null)) {
						JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos", "Error", 1);
					}else {
					modificar.actualizar(textMatricula, marcacomboBox, modelocomboBox, textAno, textKilometros, textPrecio);
					MenuTiendaAdmin.main(null);
					}
					setVisible(false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Por favor, rellene todos los datos", "Error", 1);
				}
			}
		});
		
	}
}
