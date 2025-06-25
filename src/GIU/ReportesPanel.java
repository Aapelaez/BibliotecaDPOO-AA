 package GIU;

import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.Publicacion;
import Logica.Usuario;
import Util.TrabajarFechas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import static Util.TrabajarFechas.formatearFecha;

 public class ReportesPanel extends JPanel {
	private CustomTable customTable;

	/**
	 * Create the panel.
	 */
	public ReportesPanel() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblReportes = new JLabel("Reportes");
		lblReportes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReportes.setBounds(30, 15, 138, 30);
		add(lblReportes);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 277, 1313, 445);
		JLabel lblSugerencia = new JLabel();
		lblSugerencia.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSugerencia.setText("<html><u>Seleccione un reporte para ver los detalles.</u></html>");
		lblSugerencia.setBounds(200, 277, 500, 30);
		add(lblSugerencia);
		lblSugerencia.setVisible(true);

		JPanel JpProVencer = new JPanel();
		JpProVencer.setBackground(Color.WHITE);
		JpProVencer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			lblSugerencia.setVisible(false);
			pintarTablaPrimReporte(scrollPane);
			add(scrollPane);
			}
		});
		JpProVencer.setLayout(null);
		JpProVencer.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		JpProVencer.setBounds(190, 84, 350, 150);
		add(JpProVencer);

		JLabel lblProximosAVencer = new JLabel("Proximos a vencer");
		lblProximosAVencer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaPrimReporte(scrollPane);
				add(scrollPane);
			}
		});
		lblProximosAVencer.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-error-30.png")));
		lblProximosAVencer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProximosAVencer.setBounds(15, 16, 221, 30);
		JpProVencer.add(lblProximosAVencer);

		JLabel label_1 = new JLabel(String.valueOf(Biblioteca.getInstance().estadisticaReporte1()));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaPrimReporte(scrollPane);
				add(scrollPane);
			}
		});
		label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_1.setBounds(25, 62, 69, 54);
		JpProVencer.add(label_1);

		JPanel JpMPrestadas = new JPanel();
		JpMPrestadas.setBackground(Color.WHITE);
		JpMPrestadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaSegReporte(scrollPane);
				add(scrollPane);
			}
		});
		JpMPrestadas.setLayout(null);
		JpMPrestadas.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		JpMPrestadas.setBounds(662, 84, 350, 150);
		add(JpMPrestadas);

		JLabel lblMasPrestadas = new JLabel("Mas Prestadas\r\n");
		lblMasPrestadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaSegReporte(scrollPane);
				add(scrollPane);
			}
		});
		lblMasPrestadas.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-estad\u00EDstica-30.png")));
		lblMasPrestadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMasPrestadas.setBounds(15, 16, 221, 30);
		JpMPrestadas.add(lblMasPrestadas);

		JLabel label_2 = new JLabel(String.valueOf(Biblioteca.getInstance().estadisticaReporte2()));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaSegReporte(scrollPane);
				add(scrollPane);
			}
		});
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_2.setBounds(25, 62, 69, 54);
		JpMPrestadas.add(label_2);

		JPanel JpUserPenalizados = new JPanel();
		JpUserPenalizados.setBackground(Color.WHITE);
		JpUserPenalizados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaTercReporte(scrollPane);
				add(scrollPane);
			}
		});
		JpUserPenalizados.setLayout(null);
		JpUserPenalizados.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		JpUserPenalizados.setBounds(1153, 84, 350, 150);
		add(JpUserPenalizados);

		JLabel lblUsuariosPenalizados = new JLabel("Usuarios Penalizados");
		lblUsuariosPenalizados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaTercReporte(scrollPane);
				add(scrollPane);
			}
		});
		lblUsuariosPenalizados.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-usuario-30 (1).png")));
		lblUsuariosPenalizados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuariosPenalizados.setBounds(15, 16, 221, 30);
		JpUserPenalizados.add(lblUsuariosPenalizados);

		JLabel label_4 = new JLabel(String.valueOf(Biblioteca.getInstance().estadisticaReporte3()));
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblSugerencia.setVisible(false);
				pintarTablaTercReporte(scrollPane);
				add(scrollPane);
			}
		});
		label_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_4.setBounds(25, 62, 69, 54);
		JpUserPenalizados.add(label_4);

	}
		private void pintarTablaPrimReporte (JScrollPane scrollPane) {
			List<String> columns = Arrays.asList(
					"F. Concep", "F. Límite", "F. Entreg", "Usuario",
					"Trabajador", "Prórrogado", "Estado"
			);

			try {
				List<Prestamo> prestamos = Biblioteca.getInstance().proximosVencer();
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
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	 private void pintarTablaSegReporte (JScrollPane scrollPane) {
		 List<String> columns = Arrays.asList(
				 "ID", "Título", "Tipo", "Materia",
				 "N. Páginas", "N. Ejempl", "Estado"

		 );

		 try {
			 List<Publicacion> publicaciones = Biblioteca.getInstance().publicacionesMasPrestadas();
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
	 }

	 private void pintarTablaTercReporte (JScrollPane scrollPane) {
		 List<String> columns = Arrays.asList(
				 "CI", "N. Usuario", "Nombre", "Género", "F. Acreditac",
				 "Prest. Activ"
		 );

		 try {
			 List<Usuario> usuarios = Biblioteca.getInstance().usuariosPenalizados();
			 Object[][] data = new Object[usuarios.size()][6];
			 int pos = 0;
			 for (Usuario u : usuarios) {
				 Object[] row = {u.getId(), u.getNumUsuario(), u.getNombre()+" "+u.getApellidos(),
						 u.getGenero(), TrabajarFechas.formatearFecha(u.getFechaAcreditacion()), u.getTorpedos().size()};
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
	 }
	}

