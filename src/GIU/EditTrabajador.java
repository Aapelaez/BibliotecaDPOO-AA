package GIU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import GIU.TextFieldID;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.NivelEscolar;
import Logica.Trabajador;
import javax.swing.border.LineBorder;

public class EditTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private TextFieldID Tfci;
	private JTextField Tfcargo;
	private JTextField Tfnombre;
	private JTextField Tfapellidos;
	private JTextField Tfgenero;

	/**
	 * Create the dialog.
	 */
	public EditTrabajador(final Trabajador edit,final MainScreen father){
		setUndecorated(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 750, 634);
		getContentPane().setLayout(null);
		
		JLabel lblAadirTrabajador = new JLabel("Editar Trabajador");
		lblAadirTrabajador.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirTrabajador.setBounds(243, 16, 212, 30);
		getContentPane().add(lblAadirTrabajador);
		
		Tfci = new TextFieldID();
		Tfci.setText(edit.getId());
		Tfci.setEditable(false);
		Tfci.setColumns(10);
		Tfci.setBounds(30, 104, 270, 40);
		getContentPane().add(Tfci);
		
		JLabel label = new JLabel("Carner de Identidad:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(30, 70, 165, 20);
		getContentPane().add(label);
		
		Tfcargo = new JTextField();
		Tfcargo.setText(edit.getCargo());
		Tfcargo.setColumns(10);
		Tfcargo.setBounds(409, 104, 270, 40);
		getContentPane().add(Tfcargo);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargo.setBounds(409, 71, 227, 20);
		getContentPane().add(lblCargo);
		
		Tfnombre = new JTextField();
		Tfnombre.setText(edit.getNombre());
		Tfnombre.setColumns(10);
		Tfnombre.setBounds(30, 215, 270, 40);
		getContentPane().add(Tfnombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(30, 179, 165, 20);
		getContentPane().add(lblNombre);
		
		Tfapellidos = new JTextField();
		Tfapellidos.setText(edit.getApellidos());
		Tfapellidos.setColumns(10);
		Tfapellidos.setBounds(409, 215, 270, 40);
		getContentPane().add(Tfapellidos);
		
		JLabel lblApellidos = new JLabel("Apellidos\r\n:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(409, 180, 165, 20);
		getContentPane().add(lblApellidos);
		
		final JComboBox CbnEscolar = new JComboBox();
		CbnEscolar.setModel(new DefaultComboBoxModel(new String[] {"Basico", "Medio", "MedioSuperior", "Superior"}));
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
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String carnetId = edit.getId();
				String cargo = Tfcargo.getText().equals("")?edit.getCargo():Tfcargo.getText();
				String nombre = Tfnombre.getText().equals("")?edit.getNombre():Tfnombre.getText();
				String apellidos = Tfapellidos.getText().equals("")?edit.getApellidos():Tfapellidos.getText();
				char genero= edit.getGenero();
				String nivelEscolar = CbnEscolar.getSelectedItem().toString();
				Biblioteca.getInstance().editarTrabajador(carnetId, nombre, apellidos, cargo, genero, NivelEscolar.valueOf(nivelEscolar),edit);
				JOptionPane.showMessageDialog(null, "Trabajador editado correctamente");
				dispose();
				father.Actualizar(4);
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(0, 128, 128));
		btnEditar.setBounds(123, 538, 165, 40);
		getContentPane().add(btnEditar);
		
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
		
		Tfgenero = new JTextField();
		Tfgenero.setEditable(false);
		Tfgenero.setText(edit.getGenero()=='M'?"Masculino":"Femenino");
		Tfgenero.setColumns(10);
		Tfgenero.setBounds(409, 328, 270, 40);
		getContentPane().add(Tfgenero);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel.setBounds(0, 0, 750, 634);
		getContentPane().add(panel);
	}
}
