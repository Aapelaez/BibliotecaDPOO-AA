package GIU;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import Logica.Biblioteca;
import Logica.Publicacion;
import Logica.Trabajador;
import Util.TrabajarFechas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrabajadoresPanel extends JPanel {
	private JTable table;
	private JTextField textField;
	private CustomTable customTable;

	/**
	 * Create the panel.
	 */
	public TrabajadoresPanel(final MainScreen father) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblTrabajadores = new JLabel("Trabajadores");
		lblTrabajadores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTrabajadores.setBounds(30, 15, 148, 30);
		add(lblTrabajadores);
		
		JButton btnNuevoTrabajador = new JButton("Nuevo Trabajador\r\n");
		btnNuevoTrabajador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddTrabajadores dialog = new AddTrabajadores(father);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNuevoTrabajador.setForeground(Color.WHITE);
		btnNuevoTrabajador.setBackground(Color.BLUE);
		btnNuevoTrabajador.setBounds(1390, 15, 228, 40);
		add(btnNuevoTrabajador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 195, 1588, 534);
		add(scrollPane);
		List<String> columns = Arrays.asList(
				"CI", "Nombre", "Genero", "Cargo",
				"Nivel Escolar", "Fecha de Contratacion"
		);

		try {
			List<Trabajador> trabajadores = Biblioteca.getInstance().getTrabajadores();
			Object[][] data = new Object[trabajadores.size()][6];
			int pos = 0;
			for (Trabajador t : trabajadores) {
				Object[] row = {t.getId(), t.getNombre()+" "+t.getApellidos(), t.getGenero()=='M'?"Masculino":"Femenino", t.getCargo(),
						t.getNivelEscolar().toString(), TrabajarFechas.formatearFecha(t.getFechaContratacion())};
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
		label.setIcon(new ImageIcon(TrabajadoresPanel.class.getResource("/Icons/icons8-b\u00FAsqueda-30 (1).png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(30, 150, 40, 40);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(72, 150, 350, 40);
		add(textField);
		
		JButton Editbutton = new JButton("Editar");
		Editbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = customTable.getSelectedRow();
				if(row!=-1){
					String ci=(String) customTable.getValueAt(row, 0);
					Trabajador Teditar =Biblioteca.getInstance().buscarTrabajador(ci);
					try {
						EditTrabajador dialog = new EditTrabajador(Teditar,father);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setLocationRelativeTo(null);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Por favor seleccione el trabajador que desea editar");
				}
			}
		});
		Editbutton.setForeground(Color.DARK_GRAY);
		Editbutton.setBackground(new Color(255, 255, 102));
		Editbutton.setBounds(1258, 150, 165, 40);
		add(Editbutton);
		
		JButton Deletebutton = new JButton("Eliminar");
		Deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = customTable.getSelectedRow();
				if(row!=-1){
					String ci=(String) customTable.getValueAt(row, 0);
					Biblioteca.getInstance().despedirTrabajador(ci);
					father.Actualizar(4);
				}else{
					JOptionPane.showMessageDialog(null, "Por favor seleccione el trabajador que desea eliminar");
				}
			}
		});
		Deletebutton.setForeground(Color.WHITE);
		Deletebutton.setBackground(Color.RED);
		Deletebutton.setBounds(1453, 150, 165, 40);
		add(Deletebutton);

	}
}
