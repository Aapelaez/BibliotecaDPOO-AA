package GIU;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel.setBounds(30, 75, 350, 150);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTotalDePublicaciones = new JLabel("Total de Publicaciones");
		lblTotalDePublicaciones.setIcon(new ImageIcon(HomePanel.class.getResource("/Icons/icons8-libro-30.png")));
		lblTotalDePublicaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalDePublicaciones.setBounds(15, 16, 221, 30);
		panel.add(lblTotalDePublicaciones);
		
		JLabel lblNewLabel = new JLabel(" 340");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		lblNewLabel.setBounds(25, 62, 69, 54);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel_1.setBounds(442, 75, 350, 150);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsuarios = new JLabel("Usuarios\r\n");
		lblUsuarios.setIcon(new ImageIcon(HomePanel.class.getResource("/Icons/icons8-usuario-30.png")));
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuarios.setBounds(15, 16, 221, 30);
		panel_1.add(lblUsuarios);
		
		JLabel label_1 = new JLabel(" 340");
		label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_1.setBounds(25, 62, 69, 54);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel_2.setBounds(854, 75, 350, 150);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPrestamosActivos = new JLabel("Prestamos Activos\r\n");
		lblPrestamosActivos.setBackground(Color.WHITE);
		lblPrestamosActivos.setIcon(new ImageIcon(HomePanel.class.getResource("/Icons/icons8-calendario-externo-ui-anggara-esquema-b\u00E1sico-anggara-putra-2-30.png")));
		lblPrestamosActivos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrestamosActivos.setBounds(15, 16, 221, 30);
		panel_2.add(lblPrestamosActivos);
		
		JLabel label_2 = new JLabel(" 340");
		label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_2.setBounds(25, 62, 69, 54);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel_3.setBounds(1266, 75, 350, 150);
		add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblVencidos = new JLabel("Vencidos\r\n");
		lblVencidos.setIcon(new ImageIcon(HomePanel.class.getResource("/Icons/icons8-calendario-externo-ui-anggara-esquema-b\u00E1sico-anggara-putra-2-30 (1).png")));
		lblVencidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVencidos.setBounds(15, 16, 221, 30);
		panel_3.add(lblVencidos);
		
		JLabel label_3 = new JLabel(" 340");
		label_3.setForeground(new Color(255, 0, 0));
		label_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		label_3.setBounds(25, 62, 69, 54);
		panel_3.add(label_3);

	}
}
