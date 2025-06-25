package GIU;

import Logica.Biblioteca;
import Logica.Publicacion;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PublicacionesPanel extends JPanel {
	private JTextField textField;
	private CustomTable customTable;

	/**
	 * Create the panel.
	 */
	public PublicacionesPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblPublicaciones = new JLabel("Publicaciones");
		lblPublicaciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPublicaciones.setBounds(30, 15, 138, 30);
		add(lblPublicaciones);
		
		JButton btnNuevaPublicacion = new JButton("Nueva Publicacion");
		btnNuevaPublicacion.setForeground(Color.WHITE);
		btnNuevaPublicacion.setBackground(Color.BLUE);
		btnNuevaPublicacion.setBounds(1390, 15, 228, 40);
		add(btnNuevaPublicacion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 195, 1588, 534);
		add(scrollPane);
		List<String> columns = Arrays.asList(
				"ID", "Título", "Tipo", "Materia",
				"N. Páginas", "N. Ejempl", "Estado"

		);

		try {
			List<Publicacion> publicaciones = Biblioteca.getInstance().getPublicaciones();
			Object[][] data = new Object[publicaciones.size()][7];
			int pos = 0;
			for (Publicacion p : publicaciones) {
				Object[] row = {p.getId(), p.getTitulo(), p.getClass().getSimpleName(),
				p.getMateria(), p.getNumPaginas(), p.getCantTotalEjemp(), p.getEstado() ? "Disponible" : "Reservado"};
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
		label.setIcon(new ImageIcon(PublicacionesPanel.class.getResource("/Icons/icons8-b\u00FAsqueda-30 (1).png")));
		label.setBounds(30, 150, 40, 40);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(72, 150, 350, 40);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Editar");
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(255, 255, 102));
		button.setBounds(1258, 150, 165, 40);
		add(button);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(1453, 150, 165, 40);
		add(btnEliminar);

	}

}
