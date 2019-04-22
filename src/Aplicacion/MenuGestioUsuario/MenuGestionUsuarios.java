package Aplicacion.MenuGestioUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.MenuTiendaAdmin;
import Controladores.Login.usuarios;
import login.Register;

import java.awt.Color;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGestionUsuarios extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		MenuGestionUsuarios frame = new MenuGestionUsuarios();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public MenuGestionUsuarios() {
		usuarios controlador = new usuarios();
		setResizable(false);
		setTitle("Gestion usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuGestionUsuarios.class.getResource("/recursos/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAadirUsuarioAdministrador = new JLabel("Gestion usuarios");
		lblAadirUsuarioAdministrador.setForeground(Color.WHITE);
		lblAadirUsuarioAdministrador.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblAadirUsuarioAdministrador.setBounds(10, 11, 234, 49);
		contentPane.add(lblAadirUsuarioAdministrador);

		JComboBox usuarioscomboBox = new JComboBox();
		usuarioscomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		usuarioscomboBox.setBounds(113, 60, 142, 30);
		contentPane.add(usuarioscomboBox);
		try {
			controlador.obtenerUsuarios(usuarioscomboBox);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JComboBox rolcomboBox = new JComboBox();
		rolcomboBox.setFont(new Font("Calibri", Font.BOLD, 18));
		rolcomboBox.setBounds(113, 99, 142, 30);
		contentPane.add(rolcomboBox);
		rolcomboBox.addItem("Admin");
		rolcomboBox.addItem("Usuario");

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Calibri", Font.BOLD, 18));
		lblUsuario.setBounds(41, 62, 72, 26);
		contentPane.add(lblUsuario);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Calibri", Font.BOLD, 18));
		lblRol.setBounds(66, 101, 36, 26);
		contentPane.add(lblRol);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.actualizarUsuarios(usuarioscomboBox, rolcomboBox);
					setVisible(false);
					MenuGestionUsuarios.main(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Complete los campos");
				}
			}
		});
		btnActualizar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnActualizar.setBackground(Color.LIGHT_GRAY);
		btnActualizar.setBounds(10, 140, 245, 36);
		contentPane.add(btnActualizar);

		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MenuTiendaAdmin.main(null);
			}
		});
		btnVolverAlMen.setFont(new Font("Calibri", Font.BOLD, 18));
		btnVolverAlMen.setBackground(Color.LIGHT_GRAY);
		btnVolverAlMen.setBounds(10, 281, 245, 36);
		contentPane.add(btnVolverAlMen);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setVisible(false);
					controlador.eliminarUsuario(usuarioscomboBox, rolcomboBox);
					MenuGestionUsuarios.main(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBounds(10, 187, 245, 36);
		contentPane.add(btnEliminar);

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnAadir.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAadir.setBackground(Color.LIGHT_GRAY);
		btnAadir.setBounds(10, 234, 245, 36);
		contentPane.add(btnAadir);
	}

}
