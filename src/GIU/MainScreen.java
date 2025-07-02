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
	private JLabel JlTrabajadores;

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setResizable(false);
		setTitle("Gestion de Biblioteca");
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
				JlTrabajadores.setForeground(Color.BLACK);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); 
		        HomePanel p1 = new HomePanel();
		        JpContainer.add(p1, BorderLayout.CENTER); 
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
				JlTrabajadores.setForeground(Color.BLACK);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); 
		        PublicacionesPanel p1 = new PublicacionesPanel(MainScreen.this);
		        JpContainer.add(p1, BorderLayout.CENTER); 
		        JpContainer.revalidate();
		        JpContainer.repaint();
				
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
				JlTrabajadores.setForeground(Color.BLACK);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); 
		        PrestamosPanel p1 = new PrestamosPanel();
		        JpContainer.add(p1, BorderLayout.CENTER); 
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
				JlTrabajadores.setForeground(Color.BLACK);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); 
		        UsuarioPanel p1 = new UsuarioPanel(MainScreen.this);
		        JpContainer.add(p1, BorderLayout.CENTER); 
		        JpContainer.revalidate();
		        JpContainer.repaint();
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
				JlTrabajadores.setForeground(Color.BLACK);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); 
		        ReportesPanel p1 = new ReportesPanel();
		        JpContainer.add(p1, BorderLayout.CENTER); 
		        JpContainer.revalidate();
		        JpContainer.repaint();
			}
		});
		JlReportes.setHorizontalAlignment(SwingConstants.CENTER);
		JlReportes.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlReportes.setBounds(0, 528, 200, 60);
		panel.add(JlReportes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Icons/icons8-biblioteca-100.png")));
		lblNewLabel.setBounds(0, 0, 200, 150);
		panel.add(lblNewLabel);
		
		JlTrabajadores = new JLabel("Trabajadores");
		JlTrabajadores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JlHome.setForeground(Color.BLACK);
				JlPublicaciones.setForeground(Color.BLACK);
				JlPrestamos.setForeground(Color.BLACK);
				JlUsuarios.setForeground(Color.BLACK);
				JlReportes.setForeground(Color.BLACK);
				JlTrabajadores.setForeground(Color.BLUE);
				
				JpContainer.removeAll();
		        JpContainer.setLayout(new BorderLayout()); 
		        TrabajadoresPanel p1 = new TrabajadoresPanel(MainScreen.this);
		        JpContainer.add(p1, BorderLayout.CENTER); 
		        JpContainer.revalidate();
		        JpContainer.repaint();
				
			}
		});
		JlTrabajadores.setHorizontalAlignment(SwingConstants.CENTER);
		JlTrabajadores.setFont(new Font("Tahoma", Font.BOLD, 24));
		JlTrabajadores.setBounds(0, 452, 200, 60);
		panel.add(JlTrabajadores);
		
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
        JpContainer.setLayout(new BorderLayout());
        HomePanel p1 = new HomePanel();
        JpContainer.add(p1, BorderLayout.CENTER);
        JpContainer.revalidate();
        JpContainer.repaint();
        
	}
	public void Actualizar(int panel){
    	switch (panel) {
		case 1:
			JpContainer.removeAll();
	        JpContainer.setLayout(new BorderLayout()); 
	        PublicacionesPanel p1 = new PublicacionesPanel(MainScreen.this);
	        JpContainer.add(p1, BorderLayout.CENTER); 
	        JpContainer.revalidate();
	        JpContainer.repaint();
			break;
		case 3:
			JpContainer.removeAll();
	        JpContainer.setLayout(new BorderLayout()); 
	        UsuarioPanel p3 = new UsuarioPanel(MainScreen.this);
	        JpContainer.add(p3, BorderLayout.CENTER); 
	        JpContainer.revalidate();
	        JpContainer.repaint();
			break;
		case 4:
			JpContainer.removeAll();
	        JpContainer.setLayout(new BorderLayout()); 
	        TrabajadoresPanel p4 = new TrabajadoresPanel(MainScreen.this);
	        JpContainer.add(p4, BorderLayout.CENTER); 
	        JpContainer.revalidate();
	        JpContainer.repaint();
	        break;

		default:
			break;
		}
    }
	
}
