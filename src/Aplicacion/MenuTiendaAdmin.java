package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

import Aplicacion.GestionCoches.Anadir;
import Aplicacion.GestionCoches.Borrar;
import Aplicacion.GestionCoches.Listar;
import Aplicacion.GestionCoches.UpdateMatricula;
import Aplicacion.MenuGestioUsuario.MenuGestionUsuarios;
import Aplicacion.Seguro.Seguro;
import Controladores.Coches.borrar;
import Controladores.Login.buttons;
import login.Login;

import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 * 
 * @author Javi
 *
 */
public class MenuTiendaAdmin extends JFrame {

	public static JLabel labelRol = new JLabel();
	public static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		MenuTiendaAdmin frame = new MenuTiendaAdmin();
		frame.setVisible(true);

	}

	public MenuTiendaAdmin() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuTiendaAdmin.class.getResource("/recursos/Logo.png")));
		setTitle("JaShop - Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setForeground(Color.WHITE);
		lblMenu.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblMenu.setBounds(10, 0, 156, 49);
		contentPane.add(lblMenu);

		JButton buttonListar = new JButton("Listar Productos");
		buttonListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Listar.main(null);
				setVisible(false);
			}
		});
		buttonListar.setFont(new Font("Calibri", Font.BOLD, 19));
		buttonListar.setBounds(10, 46, 190, 50);
		contentPane.add(buttonListar);

		JButton btnAnadirProductos = new JButton("A\u00F1adir productos");
		btnAnadirProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Anadir.main(null);
				setVisible(false);
			}
		});
		btnAnadirProductos.setFont(new Font("Calibri", Font.BOLD, 19));
		btnAnadirProductos.setBounds(10, 107, 190, 50);
		contentPane.add(btnAnadirProductos);

		JButton btnBorrarProductos = new JButton("Borrar Productos");
		btnBorrarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar.main(null);
				setVisible(false);
			}
		});
		btnBorrarProductos.setFont(new Font("Calibri", Font.BOLD, 19));
		btnBorrarProductos.setBounds(10, 231, 190, 50);
		contentPane.add(btnBorrarProductos);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuTiendaAdmin.class.getResource("/recursos/Logo.png")));
		lblNewLabel.setBounds(232, 89, 229, 131);
		contentPane.add(lblNewLabel);

		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateMatricula.main(null);
				setVisible(false);
			}
		});
		btnModificarProducto.setFont(new Font("Calibri", Font.BOLD, 19));
		btnModificarProducto.setBounds(10, 292, 190, 50);
		contentPane.add(btnModificarProducto);

		JButton button = new JButton("Cerrar Sesi\u00F3n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 19));
		button.setBounds(232, 292, 205, 50);
		contentPane.add(button);

		JButton btnGestionUser = new JButton("Gestionar usuarios");
		btnGestionUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGestionUsuarios.main(null);
				setVisible(false);
			}
		});
		btnGestionUser.setFont(new Font("Calibri", Font.BOLD, 19));
		btnGestionUser.setBounds(232, 231, 205, 50);
		contentPane.add(btnGestionUser);

		JButton btnSeguro = new JButton("Seguro");
		btnSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seguro.main(null);
				setVisible(false);
			}
		});
		btnSeguro.setFont(new Font("Calibri", Font.BOLD, 19));
		btnSeguro.setBounds(10, 168, 190, 50);
		contentPane.add(btnSeguro);

		JLabel label = new JLabel("Rol:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		label.setBounds(210, 21, 67, 49);
		contentPane.add(label);
		JLabel labelRol = new JLabel("Usuario");
		labelRol.setForeground(Color.WHITE);
		labelRol.setFont(new Font("Lucida Handwriting", Font.BOLD, 16));
		labelRol.setBounds(276, 21, 185, 49);

		contentPane.add(getLabelRol());

		if (getLabelRol().getText().equals("Usuario")) {
			btnBorrarProductos.setEnabled(false);
			btnModificarProducto.setEnabled(false);
			btnGestionUser.setEnabled(false);
			btnSeguro.setEnabled(false);
		}

	}

	public static JLabel getLabelRol() {
		return labelRol;
	}

	public static void setLabelRol(JLabel labelRol) {
		MenuTiendaAdmin.labelRol = labelRol;
	}

}
