package GIU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import GIU.TextFieldID;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import Logica.Biblioteca;

public class AddUsuario extends JDialog {

	private final JPanel CpGenero = new JPanel();
	private TextFieldID JtCid;
	private JTextField JtName;
	private JTextField JtApellidos;
	private JTextField JtIdu;
	private JComboBox CbGenero;

	/**
	 * Create the dialog.
	 */
	public AddUsuario(final MainScreen father) {
		setUndecorated(true);
		setBounds(100, 100, 720, 650);
		getContentPane().setLayout(new BorderLayout());
		CpGenero.setBackground(Color.WHITE);
		CpGenero.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		getContentPane().add(CpGenero, BorderLayout.CENTER);
		CpGenero.setLayout(null);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String carnetId = JtCid.getText();
				String nombre = JtName.getText();
				String apellido =JtApellidos.getText();
				String identificador = JtIdu.getText();
				char genero = CbGenero.getSelectedItem().toString().equals("Masculino")?'M':'F';
				if(!carnetId.equals("") && !nombre.equals("") && !apellido.equals("") && !identificador.equals("")){
					try{
					Biblioteca.getInstance().agregarUsuarios(carnetId, nombre, apellido, genero, identificador);
					JOptionPane.showMessageDialog(null, "Trabajador añadido correctamente");
					dispose();
					father.Actualizar(3);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else{
					JOptionPane.showMessageDialog(null, "Algunos campos no estan rellenos por favor revisar todos los campos");
				}
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(123, 538, 165, 40);
		CpGenero.add(button);
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		button_1.setBounds(382, 538, 165, 40);
		CpGenero.add(button_1);
		
		JLabel lblAadirUsuario = new JLabel("A\u00F1adir Usuario");
		lblAadirUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirUsuario.setBounds(253, 16, 212, 30);
		CpGenero.add(lblAadirUsuario);
		
		JLabel lblCarnerDeIdentidad = new JLabel("Carner de Identidad:");
		lblCarnerDeIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCarnerDeIdentidad.setBounds(30, 70, 165, 20);
		CpGenero.add(lblCarnerDeIdentidad);
		
		JtCid = new TextFieldID();
		JtCid.setColumns(10);
		JtCid.setBounds(30, 104, 270, 40);
		CpGenero.add(JtCid);
		
		JLabel lblNombre = new JLabel("Nombre:\r\n");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(30, 179, 165, 20);
		CpGenero.add(lblNombre);
		
		JtName = new JTextField();
		JtName.setColumns(10);
		JtName.setBounds(30, 215, 270, 40);
		CpGenero.add(JtName);
		
		JLabel lblApellidos = new JLabel("Apellidos:\r\n");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(362, 179, 165, 20);
		CpGenero.add(lblApellidos);
		
		JtApellidos = new JTextField();
		JtApellidos.setColumns(10);
		JtApellidos.setBounds(362, 215, 270, 40);
		CpGenero.add(JtApellidos);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenero.setBounds(30, 292, 165, 20);
		CpGenero.add(lblGenero);
		
		CbGenero = new JComboBox();
		CbGenero.setEditable(true);
		CbGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		CbGenero.setBounds(30, 328, 258, 40);
		CpGenero.add(CbGenero);
		
		JtIdu = new JTextField();
		JtIdu.setColumns(10);
		JtIdu.setBounds(362, 104, 270, 40);
		CpGenero.add(JtIdu);
		
		JLabel lblIdentificadorDelUsuario = new JLabel("Identificador del Usuario:");
		lblIdentificadorDelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdentificadorDelUsuario.setBounds(362, 71, 227, 20);
		CpGenero.add(lblIdentificadorDelUsuario);
	}
}
