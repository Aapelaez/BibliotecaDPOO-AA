package GIU;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private JPanel JpContainer = new JPanel();
	private JLabel JlHome;
	private JLabel JlPublicaciones;
	private JLabel JlPrestamos;
	private JLabel JlUsuarios;
	private JLabel JlReportes;
	private JLabel JlCerrarSesion;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setResizable(false);
		setTitle("Gestios de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1870, 950);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 200, 894);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JlHome = new JLabel("Home");
		JlHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.blue);
				JlPublicaciones.setForeground(Color.BLACK);
				JlPrestamos.setForeground(Color.BLACK);
				JlUsuarios.setForeground(Color.BLACK);
				JlReportes.setForeground(Color.BLACK);
				JlCerrarSesion.setForeground(Color.BLACK);
				
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); // Establecemos BorderLayout
		        HomePanel p1 = new HomePanel();
		        JpContainer.add(p1, BorderLayout.CENTER); // Añadimos al centro
		        JpContainer.revalidate();
		        JpContainer.repaint();
			}
		});
		JlHome.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlHome.setForeground(Color.blue);
		JlHome.setHorizontalAlignment(SwingConstants.CENTER);
		JlHome.setBounds(0, 150, 200, 60);
		panel.add(JlHome);
		
		JlPublicaciones = new JLabel("Publicaciones");
		JlPublicaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.BLACK);
				JlPublicaciones.setForeground(Color.BLUE);
				JlPrestamos.setForeground(Color.BLACK);
				JlUsuarios.setForeground(Color.BLACK);
				JlReportes.setForeground(Color.BLACK);
				JlCerrarSesion.setForeground(Color.BLACK);
				
			}
		});
		JlPublicaciones.setHorizontalAlignment(SwingConstants.CENTER);
		JlPublicaciones.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlPublicaciones.setBounds(0, 220, 200, 60);
		panel.add(JlPublicaciones);
		
		JlPrestamos = new JLabel("Prestamos");
		JlPrestamos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.BLACK);
				JlPublicaciones.setForeground(Color.BLACK);
				JlPrestamos.setForeground(Color.BLUE);
				JlUsuarios.setForeground(Color.BLACK);
				JlReportes.setForeground(Color.BLACK);
				JlCerrarSesion.setForeground(Color.BLACK);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); // Establecemos BorderLayout
		        ReportesPanel p1 = new ReportesPanel();
		        JpContainer.add(p1, BorderLayout.CENTER); // Añadimos al centro
		        JpContainer.revalidate();
		        JpContainer.repaint();
			}
		});
		JlPrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		JlPrestamos.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlPrestamos.setBounds(0, 300, 200, 60);
		panel.add(JlPrestamos);
		
		JlUsuarios = new JLabel("Usuarios");
		JlUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.BLACK);
				JlPublicaciones.setForeground(Color.BLACK);
				JlPrestamos.setForeground(Color.BLACK);
				JlUsuarios.setForeground(Color.BLUE);
				JlReportes.setForeground(Color.BLACK);
				JlCerrarSesion.setForeground(Color.BLACK);
			}
		});
		JlUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		JlUsuarios.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlUsuarios.setBounds(0, 376, 200, 60);
		panel.add(JlUsuarios);
		
		JlReportes = new JLabel("Reportes");
		JlReportes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.BLACK);
				JlPublicaciones.setForeground(Color.BLACK);
				JlPrestamos.setForeground(Color.BLACK);
				JlUsuarios.setForeground(Color.BLACK);
				JlReportes.setForeground(Color.BLUE);
				JlCerrarSesion.setForeground(Color.BLACK);
			}
		});
		JlReportes.setHorizontalAlignment(SwingConstants.CENTER);
		JlReportes.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlReportes.setBounds(0, 452, 200, 60);
		panel.add(JlReportes);
		
		JlCerrarSesion = new JLabel("Cerrar Sesion");
		JlCerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.BLACK);
				JlPublicaciones.setForeground(Color.BLACK);
				JlPrestamos.setForeground(Color.BLACK);
				JlUsuarios.setForeground(Color.BLACK);
				JlReportes.setForeground(Color.BLACK);
				JlCerrarSesion.setForeground(Color.BLUE);
			}
		});
		JlCerrarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		JlCerrarSesion.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlCerrarSesion.setBounds(0, 528, 200, 60);
		panel.add(JlCerrarSesion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Icons/icons8-biblioteca-100.png")));
		lblNewLabel.setBounds(0, 0, 200, 150);
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(200, 0, 1648, 894);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JpContainer.setBounds(0, 150, 1648, 744);
		panel_2.add(JpContainer);
		JpContainer.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema  de Biblioteca");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(15, 42, 307, 30);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Biblioteca Municipal Central");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(0, 88, 286, 20);
		panel_2.add(lblNewLabel_2);
		
		JpContainer.removeAll();
        JpContainer.setLayout(new BorderLayout()); // Establecemos BorderLayout
        HomePanel p1 = new HomePanel();
        JpContainer.add(p1, BorderLayout.CENTER); // Añadimos al centro
        JpContainer.revalidate();
        JpContainer.repaint();
	}
}
