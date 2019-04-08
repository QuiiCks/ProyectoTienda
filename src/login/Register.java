package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textPassword;
	private JTextField textUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/recursos/Logo.png")));
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 245, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Lucida Handwriting", Font.BOLD, 22));
		lblRegister.setBounds(31, 11, 156, 49);
		contentPane.add(lblRegister);
		
		JLabel labelUser = new JLabel("User");
		labelUser.setFont(new Font("Calibri", Font.BOLD, 18));
		labelUser.setBounds(21, 61, 133, 26);
		contentPane.add(labelUser);
		
		JLabel labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Calibri", Font.BOLD, 18));
		labelPassword.setBounds(21, 124, 133, 26);
		contentPane.add(labelPassword);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Calibri", Font.BOLD, 18));
		textPassword.setColumns(10);
		textPassword.setBounds(21, 149, 156, 26);
		contentPane.add(textPassword);
		
		textUser = new JTextField();
		textUser.setFont(new Font("Calibri", Font.BOLD, 18));
		textUser.setColumns(10);
		textUser.setBounds(21, 87, 156, 26);
		contentPane.add(textUser);
		
		JButton buttonFinish = new JButton("Finish");
		buttonFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Controladores.buttons.buttonRegister(textUser, textPassword);
					Login.main(null);
					setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
					Login.main(null);
					setVisible(false);
				}
			}
		});
		buttonFinish.setFont(new Font("Calibri", Font.BOLD, 18));
		buttonFinish.setBackground(Color.LIGHT_GRAY);
		buttonFinish.setBounds(21, 189, 156, 36);
		contentPane.add(buttonFinish);
	}

}
