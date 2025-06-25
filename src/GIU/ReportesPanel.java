 package GIU;

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

public class ReportesPanel extends JPanel {
	private JTable table;

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
		
		JPanel JpProVencer = new JPanel();
		JpProVencer.setBackground(Color.WHITE);
		JpProVencer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
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
			}
		});
		lblProximosAVencer.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-error-30.png")));
		lblProximosAVencer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProximosAVencer.setBounds(15, 16, 221, 30);
		JpProVencer.add(lblProximosAVencer);
		
		JLabel label_1 = new JLabel(" 340");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
			}
		});
		lblMasPrestadas.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-estad\u00EDstica-30.png")));
		lblMasPrestadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMasPrestadas.setBounds(15, 16, 221, 30);
		JpMPrestadas.add(lblMasPrestadas);
		
		JLabel label_2 = new JLabel(" 340");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
			}
		});
		lblUsuariosPenalizados.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-usuario-30 (1).png")));
		lblUsuariosPenalizados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuariosPenalizados.setBounds(15, 16, 221, 30);
		JpUserPenalizados.add(lblUsuariosPenalizados);
		
		JLabel label_4 = new JLabel(" 340");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		label_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_4.setBounds(25, 62, 69, 54);
		JpUserPenalizados.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 277, 1313, 445);
		add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(table);

	}

}
