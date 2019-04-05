package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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

import Controladores.borrar;

import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * 
 * @author Javi
 *
 */
public class MenuTienda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTienda frame = new MenuTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MenuTienda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuTienda.class.getResource("/recursos/Logo.png")));
		setTitle("JaShop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 281);
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
		
		JButton btnAadirProductos = new JButton("A\u00F1adir productos");
		btnAadirProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Anadir.main(null);
				setVisible(false);
			}
		});
		btnAadirProductos.setFont(new Font("Calibri", Font.BOLD, 19));
		btnAadirProductos.setBounds(10, 107, 190, 50);
		contentPane.add(btnAadirProductos);
		
		JButton btnBorrarProductos = new JButton("Borrar Productos");
		btnBorrarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar.main(null);
				setVisible(false);
			}
		});
		btnBorrarProductos.setFont(new Font("Calibri", Font.BOLD, 19));
		btnBorrarProductos.setBounds(10, 167, 190, 50);
		contentPane.add(btnBorrarProductos);
	}
}
