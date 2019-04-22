package Aplicacion.GestionCoches;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Aplicacion.MenuTiendaAdmin;
import Controladores.Coches.comprobarMatricula;
import Controladores.Coches.filtrar;
import Controladores.Coches.modeloCoche;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Listar extends JFrame {

	private JPanel contentPane;
	private JTextField textAno;
	private JTextField textKM0;
	private JTextField textKM1;
	private JTable tablaConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Listar frame = new Listar();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public Listar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Listar.class.getResource("/recursos/Logo.png")));
		setTitle("JaShop - Listar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblListar = new JLabel("Listar");
		lblListar.setForeground(Color.WHITE);
		lblListar.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblListar.setBounds(10, 0, 156, 49);
		contentPane.add(lblListar);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMarca.setBounds(10, 47, 133, 26);
		contentPane.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblModelo.setBounds(10, 89, 81, 26);
		contentPane.add(lblModelo);

		JComboBox marcacomboBox = new JComboBox();

		marcacomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		marcacomboBox.setBounds(120, 46, 131, 30);
		contentPane.add(marcacomboBox);
		marcacomboBox.addItem("Cualquiera");
		marcacomboBox.addItem("Seat");
		marcacomboBox.addItem("Opel");
		marcacomboBox.addItem("Ford");
		marcacomboBox.addItem("Renault");
		marcacomboBox.addItem("Chevrolet");
		marcacomboBox.addItem("Audi");
		marcacomboBox.addItem("BMW");
		marcacomboBox.addItem("Kia");
		marcacomboBox.addItem("Lexus");
		marcacomboBox.addItem("Mazda");
		marcacomboBox.addItem("Mercedes");
		marcacomboBox.addItem("Peugeot");
		marcacomboBox.addItem("Toyota");
		marcacomboBox.addItem("Volkswagen");
		marcacomboBox.addItem("Volvo");

		JComboBox modelocomboBox = new JComboBox();
		modelocomboBox.setModel(new DefaultComboBoxModel(new String[] { "Cualquiera" }));
		modelocomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		modelocomboBox.setBounds(120, 87, 131, 30);
		modelocomboBox.setVisible(true);
		contentPane.add(modelocomboBox);

		JLabel lblAo = new JLabel("A\u00F1o");
		lblAo.setFont(new Font("Calibri", Font.BOLD, 18));
		lblAo.setBounds(10, 126, 133, 26);
		contentPane.add(lblAo);

		textAno = new JTextField();
		textAno.setFont(new Font("Calibri", Font.BOLD, 18));
		textAno.setColumns(10);
		textAno.setBounds(120, 128, 133, 26);
		contentPane.add(textAno);
		// EXPRESION REGULAR

		textAno.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textAno.setText("");
			}
		});

		JLabel lblRangoDeKilometros = new JLabel("Rango de kilometros");
		lblRangoDeKilometros.setFont(new Font("Calibri", Font.BOLD, 18));
		lblRangoDeKilometros.setBounds(10, 163, 167, 26);
		contentPane.add(lblRangoDeKilometros);

		textKM0 = new JTextField();
		textKM0.setText("0");
		textKM0.setFont(new Font("Calibri", Font.BOLD, 18));
		textKM0.setColumns(10);
		textKM0.setBounds(10, 192, 81, 26);
		contentPane.add(textKM0);

		textKM1 = new JTextField();
		textKM1.setText("2000000");
		textKM1.setFont(new Font("Calibri", Font.BOLD, 18));
		textKM1.setColumns(10);
		textKM1.setBounds(152, 192, 81, 26);
		contentPane.add(textKM1);

		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setFont(new Font("Calibri", Font.BOLD, 18));
		lblHasta.setBounds(101, 192, 41, 26);
		contentPane.add(lblHasta);

		Object titulos[] = { "Matricula", "Marca", "Modelo", "Año", "KM", "Precio" };
		Object celdas[][] = new Object[12][6];
		JScrollPane scroll = new JScrollPane();
		JTable tablaConsulta = new JTable(celdas, titulos);
		tablaConsulta.setBounds(281, 48, 469, 170);

		scroll.setViewportView(tablaConsulta);
		scroll.setBounds(263, 47, 497, 217);
		getContentPane().add(scroll);

		String marca = (String) marcacomboBox.getSelectedItem();
		modeloCoche controlador = new modeloCoche();

		// Listener para controlar ambos comboBox
		marcacomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				// Verificamos si hay un cambio de seleccion
				if (event.getStateChange() == ItemEvent.SELECTED) {
					// Verificamos que el item seleccionado sea distinto a 0, que es el
					// predeterminado
					if (marcacomboBox.getSelectedIndex() > 0) {
						modelocomboBox.setModel(new DefaultComboBoxModel(
								controlador.getModelos(marcacomboBox.getSelectedItem().toString())));
					}
				}
			}
		});

		JButton buttonFiltrar = new JButton("Filtrar");
		buttonFiltrar.setFont(new Font("Calibri", Font.BOLD, 18));
		buttonFiltrar.setBackground(Color.LIGHT_GRAY);
		buttonFiltrar.setBounds(10, 228, 241, 36);
		contentPane.add(buttonFiltrar);

		JButton buttonMenu = new JButton("Volver al menu");
		buttonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTiendaAdmin.main(null);
				setVisible(false);
			}
		});
		buttonMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		buttonMenu.setBackground(Color.LIGHT_GRAY);
		buttonMenu.setBounds(10, 283, 241, 36);
		contentPane.add(buttonMenu);
		buttonFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent es) {
				try {
					String nombre = textAno.getText();

					Pattern pat = Pattern.compile("^([0-9]){0,4}$");
					Matcher mat = pat.matcher(nombre);

					String kilometros1 = textKM0.getText();
					String kilometros2 = textKM1.getText();
					Pattern patkm = Pattern.compile("^([0-9]){0,10}$");
					Matcher matkm1 = patkm.matcher(kilometros1);
					Matcher matkm2 = patkm.matcher(kilometros2);

					if (mat.find()) {
						if (matkm1.find() && matkm2.find()) {
							filtrar controlador = new filtrar();
							controlador.filtrar(marcacomboBox, modelocomboBox, textAno, textKM0, textKM1, tablaConsulta);
						} else {
							JOptionPane.showMessageDialog(null,
									"Los campos de kilometros solo pueden contener numeros");
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"El campo año tiene que estar compuesto por un maximo de 4 numeros");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
