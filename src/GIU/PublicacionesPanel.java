package GIU;

import Logica.Biblioteca;
import Logica.Publicacion;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PublicacionesPanel extends JPanel {
	private JTextField textField;
	private CustomTable customTable;

	/**
	 * Create the panel.
	 */
	public PublicacionesPanel(final MainScreen father) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblPublicaciones = new JLabel("Publicaciones");
		lblPublicaciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPublicaciones.setBounds(30, 15, 138, 30);
		add(lblPublicaciones);
		
		JButton btnNuevaPublicacion = new JButton("Nueva Publicacion");
		btnNuevaPublicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPublicaciones panel = new AddPublicaciones(father);
				panel.setVisible(true);
				panel.setLocationRelativeTo(null);
			}
		});
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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = customTable.getSelectedRow();
				if(row!=-1){
					String idPublicacion = (String) customTable.getValueAt(row, 0);
					Publicacion p= Biblioteca.getInstance().buscarPublicacion(idPublicacion);
					try {
						EditPublicaciones dialog = new EditPublicaciones(father,p);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setBackground(new Color(255, 255, 102));
		button.setBounds(1258, 150, 165, 40);
		add(button);
		
		JButton btnEliminar = new JButton("Modificar Estado");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos=customTable.getSelectedRow();
				if(pos!=-1){
				if(Biblioteca.getInstance().getPublicaciones().get(pos).getEstado()){
					Biblioteca.getInstance().desactivarPublicacion(Biblioteca.getInstance().getPublicaciones().get(pos).getId());
					father.Actualizar(1);
				}else{
					Biblioteca.getInstance().activarPublicacion(Biblioteca.getInstance().getPublicaciones().get(pos).getId());
					father.Actualizar(1);
				}
				} else if (!Biblioteca.getInstance().getPublicaciones().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione una publicación para modificar su estado", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "No hay publicaciones registradas", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(1453, 150, 165, 40);
		add(btnEliminar);

	}

}
