package GIU;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class TrabajadoresPanel extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TrabajadoresPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTrabajadores.setBounds(30, 15, 148, 30);
		add(lblTrabajadores);
		
		JButton btnNuevoTrabajador = new JButton("Nuevo Trabajador\r\n");
		btnNuevoTrabajador.setForeground(Color.WHITE);
		btnNuevoTrabajador.setBackground(Color.BLUE);
		btnNuevoTrabajador.setBounds(1390, 15, 228, 40);
		add(btnNuevoTrabajador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 195, 1588, 534);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TrabajadoresPanel.class.getResource("/Icons/icons8-b\u00FAsqueda-30 (1).png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(30, 150, 40, 40);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 150, 350, 40);
		add(textField);

	}
}
