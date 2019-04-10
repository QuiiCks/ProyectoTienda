package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.listar_seguro;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ListarSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarSeguro frame = new ListarSeguro();
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
	public ListarSeguro() {
		setTitle("JaShop - Listar miembros seguro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListarSeguro.class.getResource("/recursos/Logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarMiembrosDel = new JLabel("Listar miembros del seguro");
		lblListarMiembrosDel.setForeground(Color.WHITE);
		lblListarMiembrosDel.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblListarMiembrosDel.setBounds(10, 0, 389, 49);
		contentPane.add(lblListarMiembrosDel);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMatricula.setBounds(26, 111, 82, 26);
		contentPane.add(lblMatricula);
		
		textMatricula = new JTextField();
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(118, 111, 133, 26);
		contentPane.add(textMatricula);
		
		
		
		JButton button = new JButton("Volver al menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seguro.main(null);
				setVisible(false);
			}
		});
		button.setFont(new Font("Calibri", Font.BOLD, 18));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 213, 241, 36);
		contentPane.add(button);
		

		Object titulos [] = {"Matricula", "Nombre", "Primer apellido", "Segundo apellido", "Direccion de correo"};
		Object celdas [][] = new Object [12][6];
		JScrollPane scroll = new JScrollPane();
	    JTable tablaConsulta=new JTable(celdas, titulos);
		tablaConsulta.setBounds(281, 48, 469, 170);
		
		scroll.setViewportView(tablaConsulta);
		scroll.setBounds(263, 47, 649, 202);
		getContentPane().add(scroll);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar_seguro.listarMiembros(textMatricula, tablaConsulta);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnListar.setBackground(Color.LIGHT_GRAY);
		btnListar.setBounds(10, 166, 241, 36);
		contentPane.add(btnListar);
		
	}
}
