package Aplicacion.Seguro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.MenuTiendaAdmin;
import Aplicacion.Seguro.GestionSeguro.AnadirSeguro;
import Aplicacion.Seguro.GestionSeguro.BorrarSeguro;
import Aplicacion.Seguro.GestionSeguro.ListarSeguro;
import Controladores.Seguro.anadir_seguro;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Seguro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Seguro frame = new Seguro();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public Seguro() {
		setTitle("JaShop - Seguro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Seguro.class.getResource("/recursos/Logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 275);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeguro = new JLabel("Seguro");
		lblSeguro.setForeground(Color.WHITE);
		lblSeguro.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblSeguro.setBounds(10, 11, 156, 49);
		contentPane.add(lblSeguro);

		JButton btnListarMiembros = new JButton("Listar miembros");
		btnListarMiembros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarSeguro.main(null);
				setVisible(false);
			}
		});
		btnListarMiembros.setFont(new Font("Calibri", Font.BOLD, 19));
		btnListarMiembros.setBounds(10, 57, 190, 50);
		contentPane.add(btnListarMiembros);

		JButton btnAadirAlSeguro = new JButton("A\u00F1adir al seguro");
		btnAadirAlSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirSeguro.main(null);
				setVisible(false);
			}
		});
		btnAadirAlSeguro.setFont(new Font("Calibri", Font.BOLD, 19));
		btnAadirAlSeguro.setBounds(10, 118, 190, 50);
		contentPane.add(btnAadirAlSeguro);

		JButton btnBorrarDelSeguro = new JButton("Borrar del seguro");
		btnBorrarDelSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BorrarSeguro.main(null);
				setVisible(false);
			}
		});
		btnBorrarDelSeguro.setFont(new Font("Calibri", Font.BOLD, 19));
		btnBorrarDelSeguro.setBounds(10, 179, 190, 50);
		contentPane.add(btnBorrarDelSeguro);

		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTiendaAdmin.main(null);
				setVisible(false);
			}
		});
		btnVolverAlMen.setFont(new Font("Calibri", Font.BOLD, 19));
		btnVolverAlMen.setBounds(222, 179, 190, 50);
		contentPane.add(btnVolverAlMen);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Seguro.class.getResource("/recursos/Logo.png")));
		label.setBounds(210, 43, 209, 131);
		contentPane.add(label);
	}
}
