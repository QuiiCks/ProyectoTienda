package Aplicacion.Seguro.GestionSeguro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.Seguro.Seguro;
import Controladores.Seguro.anadir_seguro;
import Controladores.Seguro.listar_seguro;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AnadirSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTextField textNombre;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirSeguro frame = new AnadirSeguro();
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
	public AnadirSeguro() {
		setTitle("JaShop - A\u00F1adir al seguro");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AnadirSeguro.class.getResource("/recursos/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 320);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAadirMiembrosAl = new JLabel("A\u00F1adir miembros al seguro");
		lblAadirMiembrosAl.setForeground(Color.WHITE);
		lblAadirMiembrosAl.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblAadirMiembrosAl.setBounds(10, 11, 428, 49);
		contentPane.add(lblAadirMiembrosAl);

		JLabel label = new JLabel("Matricula");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(10, 71, 78, 26);
		contentPane.add(label);

		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(86, 71, 103, 26);
		contentPane.add(textMatricula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNombre.setBounds(10, 108, 78, 26);
		contentPane.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Calibri", Font.BOLD, 18));
		textNombre.setColumns(10);
		textNombre.setBounds(10, 131, 179, 26);
		contentPane.add(textNombre);

		JLabel lblPrimerApellido = new JLabel("Primer apellido");
		lblPrimerApellido.setFont(new Font("Calibri", Font.BOLD, 18));
		lblPrimerApellido.setBounds(10, 161, 126, 26);
		contentPane.add(lblPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo apellido");
		lblSegundoApellido.setFont(new Font("Calibri", Font.BOLD, 18));
		lblSegundoApellido.setBounds(217, 161, 148, 26);
		contentPane.add(lblSegundoApellido);

		textApellido1 = new JTextField();
		textApellido1.setFont(new Font("Calibri", Font.BOLD, 18));
		textApellido1.setColumns(10);
		textApellido1.setBounds(10, 187, 179, 26);
		contentPane.add(textApellido1);

		textApellido2 = new JTextField();
		textApellido2.setFont(new Font("Calibri", Font.BOLD, 18));
		textApellido2.setColumns(10);
		textApellido2.setBounds(217, 187, 179, 26);
		contentPane.add(textApellido2);

		JLabel lblEmail = new JLabel("Correo electr\u00F3nico");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 18));
		lblEmail.setBounds(10, 217, 179, 26);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Calibri", Font.BOLD, 18));
		textEmail.setColumns(10);
		textEmail.setBounds(10, 241, 179, 26);
		contentPane.add(textEmail);

		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String matricula = textMatricula.getText();
					String correo = textEmail.getText();
					String nombre = textNombre.getText();
					String apellido1 = textApellido1.getText();
					String apellido2 = textApellido2.getText();

					Pattern patmatricula = Pattern.compile("([0-9]{4})([A-Z]{3})");
					Matcher matmatricula = patmatricula.matcher(matricula);
					
					Pattern patnombre = Pattern.compile("[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-ZÀ-ÖØ-öø-ÿ]+\\.?)*");
					Matcher matnombre = patnombre.matcher(nombre);
					Matcher matapellido1 = patnombre.matcher(apellido1);
					Matcher matapellido2 =patnombre.matcher(apellido2);

					Pattern patemail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
					Matcher matemail = patemail.matcher(correo);
					if (matmatricula.find()) {
						if (matemail.find()) {
							if(matnombre.find()&&matapellido1.find()&&matapellido2.find()) {
								anadir_seguro.anadiSeguro(textMatricula, textNombre, textApellido1, textApellido2,
										textEmail);
							}else {
								JOptionPane.showMessageDialog(null,
										"Los campos del nombre solo pueden contener texto y comienzan por mayúscula.");
							}
							
						} else {
							JOptionPane.showMessageDialog(null,
									"No es un formato de correo valido.\nEjemplo: a@gmail.com");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"El campo matricula tiene que contener el formato europeo.\nFormato europeo: 1234ABC");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(217, 66, 156, 36);
		contentPane.add(button);

		JButton btnVolverAlMenu = new JButton("Volver al menu");
		btnVolverAlMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seguro.main(null);
				setVisible(false);
			}
		});
		btnVolverAlMenu.setFont(new Font("Calibri", Font.BOLD, 18));
		btnVolverAlMenu.setBackground(Color.LIGHT_GRAY);
		btnVolverAlMenu.setBounds(217, 111, 156, 36);
		contentPane.add(btnVolverAlMenu);
	}

}
