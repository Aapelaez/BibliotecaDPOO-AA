package GIU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import javax.swing.JScrollPane;

import Logica.Biblioteca;
import Logica.Publicacion;
import Logica.Trabajador;
import Logica.Usuario;
import Util.TrabajarFechas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectUsuario extends JDialog {
	private CustomTable customTable;
	int select=0;
	Usuario prestamo;
	Publicacion Aprestar;
	Trabajador realizador;
	private JScrollPane scrollPane;
	JLabel lblNewLabel;
	private JButton btnSalir;



	/**
	 * Create the dialog.
	 */
	public SelectUsuario(final MainScreen father) {
		super(father,true);
		setUndecorated(true);
		setBounds(100, 100, 1110, 800);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel.setBounds(0, 0, 1110, 800);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Seleccione un Usuario");
		lblNewLabel.setBounds(30, 30, 173, 40);
		panel.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 250, 1049, 534);
		panel.add(scrollPane);

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

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario prestamo = null;
				int row = customTable.getSelectedRow();
				if(row!=-1){
					if(select==0){
						String numUsuario = (String) customTable.getValueAt(row, 1);
						prestamo=Biblioteca.getInstance().buscarUsuario(numUsuario);
						select++;
						List<String> columns = Arrays.asList(
								"ID", "Título", "Tipo", "Materia",
								"N. Páginas", "N. Ejempl", "Estado"

								);

						try {
							List<Publicacion> publicaciones = Biblioteca.getInstance().getPublicaciones();
							Object[][] data = new Object[publicaciones.size()][7];
							int pos = 0;
							for (Publicacion p : publicaciones) {
								Object[] newRow = {p.getId(), p.getTitulo(), p.getClass().getSimpleName(),
										p.getMateria(), p.getNumPaginas(), p.getCantTotalEjemp(), p.getEstado() ? "Disponible" : "Reservado"};
								data[pos] = newRow;
								pos++;

							}
							customTable = new CustomTable(columns, data);
							customTable.getTableHeader().setReorderingAllowed(false);

							scrollPane.setViewportView(customTable);
							scrollPane.setColumnHeaderView(customTable.getTableHeader());
						}catch (Exception e){
							throw new RuntimeException(e);
						}
						lblNewLabel.setText("Seleccione una Publicacion");
					}
					else if(select==1){
						String idPublicacion = (String) customTable.getValueAt(row, 0);
						Aprestar= Biblioteca.getInstance().buscarPublicacion(idPublicacion);
						select++;
						List<String> columns = Arrays.asList(
								"CI", "Nombre", "Genero", "Cargo",
								"Nivel Escolar", "Fecha de Contratacion"
								);

						try {
							List<Trabajador> trabajadores = Biblioteca.getInstance().getTrabajadores();
							Object[][] data = new Object[trabajadores.size()][6];
							int pos = 0;
							for (Trabajador t : trabajadores) {
								Object[] nrow = {t.getId(), t.getNombre()+" "+t.getApellidos(), t.getGenero()=='M'?"Masculino":"Femenino", t.getCargo(),
										t.getNivelEscolar().toString(), TrabajarFechas.formatearFecha(t.getFechaContratacion())};
								data[pos] = nrow;
								pos++;

							}
							customTable = new CustomTable(columns, data);
							customTable.getTableHeader().setReorderingAllowed(false);

							scrollPane.setViewportView(customTable);
							scrollPane.setColumnHeaderView(customTable.getTableHeader());
						}catch (Exception e){
							throw new RuntimeException(e);
						}
						lblNewLabel.setText("Seleccione un Trabajador");
					}
					else if(select==2){
						String ciTrabajador = (String) customTable.getValueAt(row, 0);
						System.out.print(ciTrabajador);
						Biblioteca.getInstance().atenderPrestamo(Aprestar.getId(), prestamo, ciTrabajador);
						father.Actualizar(2);
						dispose();
					}
				}
			}
		});
		btnSelecionar.setForeground(Color.WHITE);
		btnSelecionar.setBackground(Color.BLUE);
		btnSelecionar.setBounds(851, 30, 228, 40);
		panel.add(btnSelecionar);

		btnSalir = new JButton("Salir\r\n");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(914, 194, 165, 40);
		panel.add(btnSalir);


	}
}
