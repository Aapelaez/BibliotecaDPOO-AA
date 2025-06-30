package GIU;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;




import GIU.AddUsuario;
import Logica.Biblioteca;
import Logica.Publicacion;
import Logica.Usuario;
import Util.TrabajarFechas;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class UsuarioPanel extends JPanel {
	private JTextField textField;
	private CustomTable customTable;

	/**
	 * Create the panel.
	 */
	public UsuarioPanel(final MainScreen father) {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsuarios.setBounds(30, 15, 138, 30);
		add(lblUsuarios);

		JButton btnNuevoUsuario = new JButton("Nuevo Usuario\r\n");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddUsuario dialog = new AddUsuario(father);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					dialog.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnNuevoUsuario.setForeground(Color.WHITE);
		btnNuevoUsuario.setBackground(Color.BLUE);
		btnNuevoUsuario.setBounds(1390, 15, 228, 40);
		add(btnNuevoUsuario);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 195, 1588, 534);
		add(scrollPane);

		List<String> columns = Arrays.asList(
				"CI", "N. Usuario", "Nombre", "Género", "F. Acreditac",
				"Prest. Activ"
				);

		try {
			List<Usuario> usuarios = Biblioteca.getInstance().getUsuarios();
			Object[][] data = new Object[usuarios.size()][6];
			int pos = 0;
			for (Usuario u : usuarios) {
				Object[] row = {u.getId(), u.getNumUsuario(), u.getNombre()+" "+u.getApellidos(),
						u.getGenero(), TrabajarFechas.formatearFecha(u.getFechaAcreditacion()), u.getPrestamos().size()};
				//Cambiar torpedo por prestamos activos
				data[pos] = row;
				pos++;

			}
			customTable = new CustomTable(columns, data);
			customTable.getTableHeader().setReorderingAllowed(false);

			scrollPane.setViewportView(customTable);
			scrollPane.setColumnHeaderView(customTable.getTableHeader());
		}catch (Exception e){
			throw new RuntimeException(e);
		}


		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(UsuarioPanel.class.getResource("/Icons/icons8-b\u00FAsqueda-30 (1).png")));
		label.setBounds(30, 150, 40, 40);
		add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 150, 350, 40);
		add(textField);

		JButton editButton = new JButton("Editar");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = customTable.getSelectedRow();
				if(row!=-1){
					String numUsuario = (String) customTable.getValueAt(row, 1);
					Usuario edit = Biblioteca.getInstance().buscarUsuario(numUsuario);
					try {
						EditUsuario dialog = new EditUsuario(father,edit);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		editButton.setForeground(Color.DARK_GRAY);
		editButton.setBackground(new Color(255, 255, 102));
		editButton.setBounds(1453, 150, 165, 40);
		add(editButton);

	}

}
