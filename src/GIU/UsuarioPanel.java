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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableModel;

public class UsuarioPanel extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public UsuarioPanel() {
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
					AddUsuario dialog = new AddUsuario();
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
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				
			}
		));
		scrollPane.setColumnHeaderView(table);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(UsuarioPanel.class.getResource("/Icons/icons8-b\u00FAsqueda-30 (1).png")));
		label.setBounds(30, 150, 40, 40);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 150, 350, 40);
		add(textField);
		
		JButton button_1 = new JButton("Eliminar");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		button_1.setBounds(1453, 150, 165, 40);
		add(button_1);
		
		JButton button_2 = new JButton("Editar");
		button_2.setForeground(Color.DARK_GRAY);
		button_2.setBackground(new Color(255, 255, 102));
		button_2.setBounds(1258, 150, 165, 40);
		add(button_2);

	}

}
