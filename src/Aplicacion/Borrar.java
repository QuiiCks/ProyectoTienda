package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.borrar;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Borrar extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Borrar frame = new Borrar();
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
	public Borrar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Borrar.class.getResource("/recursos/Logo.png")));
		setTitle("JaShop - Borrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBorrar = new JLabel("Borrar");
		lblBorrar.setForeground(Color.WHITE);
		lblBorrar.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblBorrar.setBounds(10, 0, 156, 49);
		contentPane.add(lblBorrar);
		
		JLabel lblInsertaLaMatricula = new JLabel("Inserta la matricula a borrar");
		lblInsertaLaMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		lblInsertaLaMatricula.setBounds(10, 51, 235, 26);
		contentPane.add(lblInsertaLaMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(10, 81, 156, 26);
		contentPane.add(textMatricula);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					borrar.borrar(textMatricula);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnBorrar.setBackground(Color.LIGHT_GRAY);
		btnBorrar.setBounds(10, 118, 210, 36);
		contentPane.add(btnBorrar);
		
		JButton button = new JButton("Volver al menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuTienda.main(null);
				setVisible(false);
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 165, 210, 36);
		contentPane.add(button);
	}
}
