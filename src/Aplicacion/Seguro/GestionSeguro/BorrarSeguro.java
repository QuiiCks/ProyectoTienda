package Aplicacion.Seguro.GestionSeguro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.Seguro.Seguro;
import Controladores.Seguro.borrar_seguro;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BorrarSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrarSeguro frame = new BorrarSeguro();
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
	public BorrarSeguro() {
		setTitle("JaShop - Borrar miembros del seguro");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BorrarSeguro.class.getResource("/recursos/Logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBorrarMiembrosDel = new JLabel("Borrar miembros del seguro");
		lblBorrarMiembrosDel.setForeground(Color.WHITE);
		lblBorrarMiembrosDel.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblBorrarMiembrosDel.setBounds(10, 11, 394, 49);
		contentPane.add(lblBorrarMiembrosDel);
		
		JLabel label = new JLabel("Matricula");
		label.setFont(new Font("Calibri", Font.BOLD, 18));
		label.setBounds(10, 66, 78, 26);
		contentPane.add(label);
		
		textMatricula = new JTextField();
		
		
		
	
		textMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textMatricula.setFont(new Font("Calibri", Font.BOLD, 18));
		textMatricula.setColumns(10);
		textMatricula.setBounds(90, 66, 103, 26);
		contentPane.add(textMatricula);
		
		
		JLabel lblMiembro = new JLabel("Miembro");
		lblMiembro.setFont(new Font("Calibri", Font.BOLD, 18));
		lblMiembro.setBounds(10, 103, 78, 26);
		contentPane.add(lblMiembro);
		
		JComboBox comboBoxMiembro = new JComboBox();
		comboBoxMiembro.setFont(new Font("Calibri", Font.BOLD, 18));
		comboBoxMiembro.setBounds(90, 103, 265, 30);
		contentPane.add(comboBoxMiembro);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String matricula = textMatricula.getText();
					
					Pattern patmatricula = Pattern.compile("([0-9]{4})([A-Z]{3})");
					Matcher matmatricula = patmatricula.matcher(matricula);
					if(matmatricula.find()) {
						borrar_seguro.borrar(textMatricula, comboBoxMiembro);
					}else {
						JOptionPane.showMessageDialog(null,
								"El campo matricula tiene que contener el formato europeo.\nFormato europeo: 1234ABC");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBorrar.setFont(new Font("Calibri", Font.BOLD, 19));
		btnBorrar.setBounds(10, 199, 190, 50);
		contentPane.add(btnBorrar);
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Seguro.main(null);
				setVisible(false);
			}
		});
		btnVolverAlMen.setFont(new Font("Calibri", Font.BOLD, 19));
		btnVolverAlMen.setBounds(214, 199, 190, 50);
		contentPane.add(btnVolverAlMen);
		
		JButton btnObtenerMiembros = new JButton("Obtener miembros");
		btnObtenerMiembros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					borrar_seguro.obtenerMiembros(textMatricula, comboBoxMiembro);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnObtenerMiembros.setFont(new Font("Calibri", Font.BOLD, 13));
		btnObtenerMiembros.setBounds(203, 66, 152, 26);
		contentPane.add(btnObtenerMiembros);
		
		
            	
			
	}
}
