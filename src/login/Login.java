package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Aplicacion.MenuTiendaAdmin;
import Controladores.Login.buttons;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/recursos/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFont(new Font("Calibri", Font.BOLD, 18));
		setTitle("Login");
		setBackground(Color.GRAY);
		setBounds(100, 100, 384, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelUser = new JLabel("User");
		labelUser.setFont(new Font("Calibri", Font.BOLD, 18));
		labelUser.setBounds(21, 61, 133, 26);
		contentPane.add(labelUser);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Calibri", Font.BOLD, 18));
		labelPassword.setBounds(21, 124, 133, 26);
		contentPane.add(labelPassword);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Calibri", Font.BOLD, 18));
		textUser.setBounds(21, 87, 156, 26);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Calibri", Font.BOLD, 18));
		textPassword.setColumns(10);
		textPassword.setBounds(21, 149, 156, 26);
		contentPane.add(textPassword);
		
		JCheckBox checkRecuerdame = new JCheckBox("Recuerdame");
		checkRecuerdame.setFont(new Font("Calibri", Font.BOLD, 15));
		checkRecuerdame.setBackground(new Color(0, 102, 204));
		checkRecuerdame.setBounds(184, 152, 133, 23);
		contentPane.add(checkRecuerdame);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = textUser.getText();
				String pass = textPassword.getText();
					try {
						buttons.buttonLogin(textUser, textPassword);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						setVisible(false);
						if(checkRecuerdame.isSelected()) {
							FileWriter writer;
							try {
								writer = new FileWriter("src/login/recuerdame.txt");
								writer.write(textUser.getText()+"\n"+textPassword.getText());
								writer.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}else {
							FileWriter writer;
							try {
								writer = new FileWriter("src/login/recuerdame.txt");
								writer.write("");
								writer.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					
					
			}
		});
		buttonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		buttonLogin.setBackground(Color.LIGHT_GRAY);
		buttonLogin.setFont(new Font("Calibri", Font.BOLD, 18));
		buttonLogin.setBounds(21, 186, 156, 36);
		contentPane.add(buttonLogin);
		
		JButton buttonRegister = new JButton("Register");
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register.main(null);
				setVisible(false);
			}
		});
		buttonRegister.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		buttonRegister.setBackground(Color.LIGHT_GRAY);
		buttonRegister.setFont(new Font("Calibri", Font.BOLD, 18));
		buttonRegister.setBounds(21, 233, 156, 36);
		contentPane.add(buttonRegister);
		
		JLabel labelWelcome = new JLabel("Welcome");
		labelWelcome.setForeground(new Color(255, 255, 255));
		labelWelcome.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		labelWelcome.setBounds(21, 11, 156, 49);
		contentPane.add(labelWelcome);
		
		
		
		String ruta = "src/login/recuerdame.txt";
		File fichero = new File(ruta);
		Scanner teclado;
		try {
			teclado = new Scanner(fichero);
			while (teclado.hasNext()) {
				String data = teclado.nextLine();
				textPassword.setText(data);
				if(teclado.hasNext()) {
					textUser.setText(data);
				}
			}

			teclado.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
