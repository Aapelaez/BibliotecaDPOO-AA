package GIU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import GIU.TextFieldID;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Logica.Biblioteca;
import Logica.NivelEscolar;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class AddTrabajadores extends JDialog {
	
	private final JPanel CpGenero = new JPanel();
	private TextFieldID Tfci;
	private JTextField Tfcargo;
	private JTextField Tfnombre;
	private JTextField Tfapellidos;


	/**
	 * Create the dialog.
	 */
	public AddTrabajadores(final MainScreen father) { 
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 750, 634);
		getContentPane().setLayout(null);
		
		JLabel lblAadirTrabajador = new JLabel("A\u00F1adir Trabajador");
		lblAadirTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirTrabajador.setBounds(243, 16, 212, 30);
		getContentPane().add(lblAadirTrabajador);
		
		Tfci = new TextFieldID();
		Tfci.setColumns(10);
		Tfci.setBounds(30, 104, 270, 40);
		getContentPane().add(Tfci);
		
		JLabel label = new JLabel("Carnet de Identidad:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(30, 70, 165, 20);
		getContentPane().add(label);
		
		Tfcargo = new JTextField();
		Tfcargo.setColumns(10);
		Tfcargo.setBounds(409, 104, 270, 40);
		getContentPane().add(Tfcargo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargo.setBounds(409, 71, 227, 20);
		getContentPane().add(lblCargo);
		
		Tfnombre = new JTextField();
		Tfnombre.setColumns(10);
		Tfnombre.setBounds(30, 215, 270, 40);
		getContentPane().add(Tfnombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(30, 179, 165, 20);
		getContentPane().add(lblNombre);
		
		Tfapellidos = new JTextField();
		Tfapellidos.setColumns(10);
		Tfapellidos.setBounds(409, 215, 270, 40);
		getContentPane().add(Tfapellidos);
		
		JLabel lblApellidos = new JLabel("Apellidos\r\n:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(409, 180, 165, 20);
		getContentPane().add(lblApellidos);
		
		final JComboBox CbnEscolar = new JComboBox();
		CbnEscolar.setModel(new DefaultComboBoxModel(new String[] {"Básico", "Medio", "MedioSuperior", "Superior"}));
		CbnEscolar.setBounds(30, 328, 270, 40);
		getContentPane().add(CbnEscolar);
		
		JLabel lblNivelEscolar = new JLabel("Nivel Escolar:");
		lblNivelEscolar.setToolTipText("");
		lblNivelEscolar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNivelEscolar.setBounds(30, 292, 165, 20);
		getContentPane().add(lblNivelEscolar);
		
		JLabel label_1 = new JLabel("Genero:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(409, 293, 165, 20);
		getContentPane().add(label_1);
		
		final JComboBox Cbgenero = new JComboBox();
		Cbgenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		Cbgenero.setBounds(409, 328, 270, 40);
		getContentPane().add(Cbgenero);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String carnetId = Tfci.getText();
				String cargo = Tfcargo.getText();
				String nombre = Tfnombre.getText();
				String apellidos = Tfapellidos.getText();
				char genero= Cbgenero.getSelectedItem().toString().equals("Masculino")?'M':'F';
				String nivelEscolar = CbnEscolar.getSelectedItem().toString();
				if(!carnetId.equals("") && !cargo.equals("") && !nombre.equals("") && !apellidos.equals("")){
					try{
					Biblioteca.getInstance().contratarTrabajador(carnetId, nombre, apellidos, cargo, genero, NivelEscolar.valueOf(nivelEscolar));
					JOptionPane.showMessageDialog(null, "Trabajador añadido correctamente");
					dispose();
					father.Actualizar(4);
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}else{
					JOptionPane.showMessageDialog(null,"Algunos campos se encuentran vacios por favor revise que todos esten llenos");
				}
				
				
				 
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(123, 538, 165, 40);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		button_1.setBounds(382, 538, 165, 40);
		getContentPane().add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel.setBounds(0, 0, 750, 634);
		getContentPane().add(panel);
	}
}
