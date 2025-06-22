package GIU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIniciarSecion = new JLabel("Inicio de Sesion");
		lblIniciarSecion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIniciarSecion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSecion.setBounds(184, 32, 209, 30);
		contentPane.add(lblIniciarSecion);
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(184, 363, 209, 47);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(75, 136, 435, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(75, 95, 88, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasea.setBounds(75, 220, 115, 30);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 252, 435, 45);
		contentPane.add(textField_1);
		
		JLabel JlMensaje = new JLabel("Credenciales Incorrectas");
		JlMensaje.setVisible(false);
		JlMensaje.setForeground(new Color(255, 0, 0));
		JlMensaje.setBackground(Color.WHITE);
		JlMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		JlMensaje.setBounds(184, 313, 209, 41);
		contentPane.add(JlMensaje);
	}

}
