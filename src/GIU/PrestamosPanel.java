package GIU;

import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.Publicacion;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;

import static Util.TrabajarFechas.formatearFecha;
import static Util.TrabajarFechas.getFechaActual;

public class PrestamosPanel extends JPanel {
	private CustomTable customTable;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PrestamosPanel(final MainScreen father) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prestamos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(30, 15, 138, 30);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Nuevo Prestamos\r\n");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SelectUsuario dialog = new SelectUsuario(father);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(1390, 15, 228, 40);
		add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 195, 1588, 534);
		add(scrollPane);

		List<String> columns = Arrays.asList(
				"F. Concep", "F. Límite", "F. Entreg", "Usuario",
				"Trabajador", "Prórrogado", "Estado"
		);

		try {
			List<Prestamo> prestamos = Biblioteca.getInstance().getPrestamos();
			Object[][] data = new Object[prestamos.size()][7];
			int pos = 0;
			for (Prestamo p : prestamos) {
				Object[] row = {formatearFecha(p.getFechaConcepcion()), formatearFecha(p.getFechaLimite()), p.getFechaEntregado() != null ? formatearFecha(p.getFechaEntregado()) : "Pendiente",
						p.getUsuario().getNombre(), p.getIdTrabajador(), p.isProrrogado(), p.getEstado().toString()};
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(PrestamosPanel.class.getResource("/Icons/icons8-b\u00FAsqueda-30 (1).png")));
		lblNewLabel_1.setBounds(30, 150, 40, 40);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(72, 150, 350, 40);
		add(textField);
		textField.setColumns(10);

		//Para que es necesario el botón de editar?
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.DARK_GRAY);
		btnEditar.setBackground(new Color(255, 255, 102));
		btnEditar.setBounds(1453, 150, 165, 40);
		add(btnEditar);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos= customTable.getSelectedRow();
				if(pos!=-1){
					Prestamo p=Biblioteca.getInstance().getPrestamos().get(pos);
					Biblioteca.getInstance().recibirDevolucion(p);
				}
				//Validar devolución de préstamo ya devuelto
				else if(!Biblioteca.getInstance().getPrestamos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione el préstamo a devolver",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "No hay préstamos disponibles para devolver",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnDevolver.setForeground(Color.WHITE);
		btnDevolver.setBackground(new Color(0, 128, 128));
		btnDevolver.setBounds(1263, 150, 165, 40);
		add(btnDevolver);
		
		JButton btnProrrogar = new JButton("Prorrogar");
		btnProrrogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pos= customTable.getSelectedRow();
				if(pos!=-1){
					Prestamo p=Biblioteca.getInstance().getPrestamos().get(pos);
					Biblioteca.getInstance().procesarProrroga(p,getFechaActual());
				}
				//Validar prórroga de préstamo ya prorrogado
				else if(!Biblioteca.getInstance().getPrestamos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Seleccione el préstamo a prorrogar",
							"Error", JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "No hay préstamos disponibles para prorrogar",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnProrrogar.setForeground(Color.WHITE);
		btnProrrogar.setBackground(new Color(255, 0, 0));
		btnProrrogar.setBounds(1069, 150, 165, 40);
		add(btnProrrogar);

	}
}
