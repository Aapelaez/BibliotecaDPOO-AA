package GIU;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField JtUser;
	private JPasswordField JtPassword;
	private JLabel Mensaje; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JtUser.getText().equals("Admin") && JtPassword.getText().equals("admin1234")){
					try {
						MainScreen frame = new MainScreen();
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						dispose();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					Mensaje.setVisible(true);
				}
					
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(184, 363, 209, 47);
		contentPane.add(btnNewButton);
		
		JtUser = new JTextField();
		JtUser.setBounds(75, 136, 435, 45);
		contentPane.add(JtUser);
		JtUser.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuario.setBounds(75, 95, 88, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContrasea.setBounds(75, 220, 115, 30);
		contentPane.add(lblContrasea);
		
		JtPassword = new JPasswordField();
		JtPassword.setColumns(10);
		JtPassword.setBounds(75, 252, 435, 45);
		contentPane.add(JtPassword);
		
		Mensaje = new JLabel("Credenciales Incorrectas");
		Mensaje.setVisible(false);
		Mensaje.setForeground(new Color(255, 0, 0));
		Mensaje.setBackground(Color.WHITE);
		Mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		Mensaje.setBounds(184, 313, 209, 41);
		contentPane.add(Mensaje);
	}

}
