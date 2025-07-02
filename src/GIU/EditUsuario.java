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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import GIU.TextFieldID;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Logica.Biblioteca;
import Logica.Usuario;

public class EditUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final JPanel CpGenero = new JPanel();
	private TextFieldID JtCid;
	private JTextField JtName;
	private JTextField JtApellidos;
	private JTextField JtIdu;
	private JTextField Jtgenero;

	/**
	 * Create the dialog.
	 */
	public EditUsuario(final MainScreen father,final Usuario edit) {
		setUndecorated(true);
		setBounds(100, 100, 720, 650);
		getContentPane().setLayout(new BorderLayout());
		CpGenero.setBackground(Color.WHITE);
		CpGenero.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		getContentPane().add(CpGenero, BorderLayout.CENTER);
		CpGenero.setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String carnetId = edit.getId();
				String nombre = JtName.getText().equals("")?edit.getNombre():JtName.getText();
				String apellido =JtApellidos.getText().equals("")?edit.getApellidos():JtApellidos.getText();
				String identificador = edit.getNumUsuario();
				char genero = edit.getGenero();
				Biblioteca.getInstance().editarUsuario(carnetId, nombre, apellido, genero, identificador, edit);
				JOptionPane.showMessageDialog(null, "Trabajador editado correctamente");
				dispose();
				father.Actualizar(3);
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(0, 128, 128));
		btnEditar.setBounds(123, 538, 165, 40);
		CpGenero.add(btnEditar);
		
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
		
		JLabel lblAadirUsuario = new JLabel("Editar Usuario");
		lblAadirUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAadirUsuario.setBounds(253, 16, 212, 30);
		CpGenero.add(lblAadirUsuario);
		
		JLabel lblCarnerDeIdentidad = new JLabel("Carner de Identidad:");
		lblCarnerDeIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCarnerDeIdentidad.setBounds(30, 70, 165, 20);
		CpGenero.add(lblCarnerDeIdentidad);
		
		JtCid = new TextFieldID();
		JtCid.setText(edit.getId());
		JtCid.setEditable(false);
		JtCid.setColumns(10);
		JtCid.setBounds(30, 104, 270, 40);
		CpGenero.add(JtCid);
		
		JLabel lblNombre = new JLabel("Nombre:\r\n");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombre.setBounds(30, 179, 165, 20);
		CpGenero.add(lblNombre);
		
		JtName = new JTextField();
		JtName.setText(edit.getNombre());
		JtName.setColumns(10);
		JtName.setBounds(30, 215, 270, 40);
		CpGenero.add(JtName);
		
		JLabel lblApellidos = new JLabel("Apellidos:\r\n");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblApellidos.setBounds(362, 179, 165, 20);
		CpGenero.add(lblApellidos);
		
		JtApellidos = new JTextField();
		JtApellidos.setText(edit.getApellidos());
		JtApellidos.setColumns(10);
		JtApellidos.setBounds(362, 215, 270, 40);
		CpGenero.add(JtApellidos);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGenero.setBounds(30, 292, 165, 20);
		CpGenero.add(lblGenero);
		
		JtIdu = new JTextField();
		JtIdu.setText(edit.getNumUsuario());
		JtIdu.setEditable(false);
		JtIdu.setColumns(10);
		JtIdu.setBounds(362, 104, 270, 40);
		CpGenero.add(JtIdu);
		
		JLabel lblIdentificadorDelUsuario = new JLabel("Identificador del Usuario:");
		lblIdentificadorDelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdentificadorDelUsuario.setBounds(362, 71, 227, 20);
		CpGenero.add(lblIdentificadorDelUsuario);
		
		Jtgenero = new JTextField();
		Jtgenero.setText(edit.getGenero()=='M'?"Masculino":"Femenino");
		Jtgenero.setEditable(false);
		Jtgenero.setColumns(10);
		Jtgenero.setBounds(30, 335, 270, 40);
		CpGenero.add(Jtgenero);
	}

}
