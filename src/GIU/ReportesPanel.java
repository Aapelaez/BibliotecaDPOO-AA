 package GIU;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel.setBounds(190, 84, 350, 150);
		add(panel);
		
		JLabel lblProximosAVencer = new JLabel("Proximos a vencer");
		lblProximosAVencer.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-error-30.png")));
		lblProximosAVencer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblProximosAVencer.setBounds(15, 16, 221, 30);
		panel.add(lblProximosAVencer);
		
		JLabel label_1 = new JLabel(" 340");
		label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_1.setBounds(25, 62, 69, 54);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel_1.setBounds(662, 84, 350, 150);
		add(panel_1);
		
		JLabel lblMasPrestadas = new JLabel("Mas Prestadas\r\n");
		lblMasPrestadas.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-estad\u00EDstica-30.png")));
		lblMasPrestadas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMasPrestadas.setBounds(15, 16, 221, 30);
		panel_1.add(lblMasPrestadas);
		
		JLabel label_2 = new JLabel(" 340");
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_2.setBounds(25, 62, 69, 54);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel_2.setBounds(1153, 84, 350, 150);
		add(panel_2);
		
		JLabel label_3 = new JLabel("Proximos a vencer");
		label_3.setIcon(new ImageIcon(ReportesPanel.class.getResource("/Icons/icons8-usuario-30 (1).png")));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(15, 16, 221, 30);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel(" 340");
		label_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_4.setBounds(25, 62, 69, 54);
		panel_2.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(190, 277, 1313, 445);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);

	}

}
