package GIU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.jws.Oneway;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyledEditorKit.UnderlineAction;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SpinnerNumberModel;

import Logica.Biblioteca;
import Logica.Publicacion;
import Logica.Revista;

public class AddPublicaciones extends JFrame {

	private JPanel contentPane;
	private JTextField JtCodigo;
	private JTextField JtTitulo;
	private JTextField JtMateria;
	private JTextField JtAutores;
	private JTextField JtEditorial;
	private JTable table;
	private JLabel addAutores;
	private JSpinner SpEjemplares;
	private JSpinner SpPaginas;
	private JSpinner SpNumero;
	private JSpinner Spanno; 
	private JLabel lblNumero;
	private JLabel lblAo;
	private JLabel lblAutores;
	private JLabel lblEditorial;
	private JScrollPane scrollPane;
	private ArrayList<String> autores;
	private ArrayList<String> arbitros;
	private JLabel lblArbitros;
	private JComboBox CbTipo;


	/**
	 * Create the frame.
	 */
	public AddPublicaciones(final MainScreen father) {
	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 777);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		autores = new ArrayList<String>();
		arbitros = new ArrayList<String>();



		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo = JtCodigo.getText();
				String titulo = JtTitulo.getText();
				String materia = JtMateria.getText();
				int paginas = (Integer)SpPaginas.getValue();
				int ejemplares = (Integer) SpEjemplares.getValue();
				String tipo = CbTipo.getSelectedItem().toString();
				switch(tipo){
				case "Revista":
					int anno = (Integer)Spanno.getValue();
					int numero  = (Integer)SpNumero.getValue();
					if(!codigo.isEmpty() && !titulo.isEmpty() && !materia.isEmpty()){
						//String id, String titulo, String materia, int numPaginas, int anno, int numero, int ejemplares
						try{
						Biblioteca.getInstance().agregrarRevista(codigo, titulo, materia, paginas,true, anno, numero, ejemplares);
						JOptionPane.showMessageDialog(null, "Publicacion añadida correctamente");
						dispose();
						father.Actualizar(1);
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, e.getMessage());
							}
					}
					else{
						JOptionPane.showMessageDialog(null, "Algunos campos no estan rellenos por favor revisar todos los campos");
					}
					break;
				case "Libro":
					//String id, String titulo, String materia, int numPaginas, String editorial, int ejemplares
					String editorial = JtEditorial.getText();
					if(!codigo.isEmpty() && !titulo.isEmpty() && !materia.isEmpty() && !editorial.isEmpty() && !autores.isEmpty()){
						try{
						Biblioteca.getInstance().agregarLibro(codigo, titulo, materia, paginas, editorial, ejemplares, autores);
						JOptionPane.showMessageDialog(null, "Publicacion añadida correctamente");
						dispose();
						father.Actualizar(1);
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Algunos campos no estan rellenos por favor revisar todos los campos");
					}
					break;
				case "Articulo":
					if(!codigo.isEmpty() && !titulo.isEmpty() && !materia.isEmpty() && !arbitros.isEmpty()){
						try{
						Biblioteca.getInstance().agregrarArticulo(codigo, titulo, materia, paginas, ejemplares,arbitros);
						JOptionPane.showMessageDialog(null, "Publicacion añadida correctamente");
						dispose();
						father.Actualizar(1);
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Algunos campos no estan rellenos por favor revisar todos los campos");
					}
					break;

				}
			}
		});
		btnAadir.setForeground(Color.WHITE);
		btnAadir.setBackground(new Color(0, 128, 128));
		btnAadir.setBounds(170, 721, 165, 40);
		contentPane.add(btnAadir);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(501, 721, 165, 40);
		contentPane.add(btnSalir);

		JLabel lblNewLabel = new JLabel("A\u00F1adir Publicaciones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(336, 16, 212, 30);
		contentPane.add(lblNewLabel);

		JtCodigo = new JTextField();
		JtCodigo.setBounds(65, 120, 270, 40);
		contentPane.add(JtCodigo);
		JtCodigo.setColumns(10);

		JLabel lblIdDigitos = new JLabel("ID(6 digitos)");
		lblIdDigitos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdDigitos.setBounds(65, 84, 134, 20);
		contentPane.add(lblIdDigitos);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(460, 85, 134, 20);
		contentPane.add(lblTipo);

		CbTipo = new JComboBox();
		CbTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String tipo = CbTipo.getSelectedItem().toString();
				switch(tipo){
				case "Revista":
					addAutores.setVisible(false);
					Spanno.setVisible(true);
					SpNumero.setVisible(true);
					lblNumero.setVisible(true);
					lblAo.setVisible(true);
					lblAutores.setVisible(false);
					lblEditorial.setVisible(false);
					JtAutores.setVisible(false);
					JtEditorial.setVisible(false);
					scrollPane.setVisible(false);
					table.setVisible(false);
					lblArbitros.setVisible(false);
					break;
				case "Libro":
					addAutores.setVisible(true);
					Spanno.setVisible(false);
					SpNumero.setVisible(false);
					lblNumero.setVisible(false);
					lblAo.setVisible(false);
					lblAutores.setVisible(true);
					lblEditorial.setVisible(true);
					JtAutores.setVisible(true);
					JtEditorial.setVisible(true);
					scrollPane.setVisible(true);
					table.setVisible(true);
					lblArbitros.setVisible(false);
					definirTabla(autores);
					break;
				case "Articulo":
					addAutores.setVisible(true);
					Spanno.setVisible(false);
					SpNumero.setVisible(false);
					lblNumero.setVisible(false);
					lblAo.setVisible(false);
					lblAutores.setVisible(false);
					lblEditorial.setVisible(false);
					JtAutores.setVisible(true);
					JtEditorial.setVisible(false);
					scrollPane.setVisible(true);
					table.setVisible(true);
					lblArbitros.setVisible(true);
					definirTabla(arbitros);
					break;

				}
			}
		});
		CbTipo.setModel(new DefaultComboBoxModel(new String[] {"Revista", "Articulo", "Libro"}));
		CbTipo.setBounds(460, 120, 270, 40);

		contentPane.add(CbTipo);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(65, 202, 134, 20);
		contentPane.add(lblTitulo);

		JtTitulo = new JTextField();
		JtTitulo.setColumns(10);
		JtTitulo.setBounds(65, 238, 270, 40);
		contentPane.add(JtTitulo);

		JtMateria = new JTextField();
		JtMateria.setColumns(10);
		JtMateria.setBounds(460, 238, 270, 40);
		contentPane.add(JtMateria);

		JLabel lblMaterial = new JLabel("Materia:");
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaterial.setBounds(460, 203, 134, 20);
		contentPane.add(lblMaterial);

		SpPaginas = new JSpinner();
		SpPaginas.setBounds(65, 346, 270, 40);
		contentPane.add(SpPaginas);

		JLabel lblDePaginas = new JLabel("# de Paginas");
		lblDePaginas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDePaginas.setBounds(65, 316, 134, 20);
		contentPane.add(lblDePaginas);

		SpEjemplares = new JSpinner();
		SpEjemplares.setBounds(460, 346, 270, 40);
		contentPane.add(SpEjemplares);

		JLabel lblCantidadDeEjemplares = new JLabel("Cantidad de Ejemplares:");
		lblCantidadDeEjemplares.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidadDeEjemplares.setBounds(460, 316, 236, 20);
		contentPane.add(lblCantidadDeEjemplares);

		Spanno = new JSpinner();
		Spanno.setModel(new SpinnerNumberModel(2025, 1000, 2025, 1));
		Spanno.setBounds(65, 460, 270, 40);
		contentPane.add(Spanno);

		SpNumero = new JSpinner();
		SpNumero.setBounds(460, 460, 270, 40);
		contentPane.add(SpNumero);

		lblAo = new JLabel("A\u00F1o\r\n");
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAo.setBounds(65, 424, 134, 20);
		contentPane.add(lblAo);

		lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumero.setBounds(460, 425, 134, 20);
		contentPane.add(lblNumero);

		JtAutores = new JTextField();
		JtAutores.setVisible(false);
		JtAutores.setBounds(65, 460, 270, 40);
		contentPane.add(JtAutores);
		JtAutores.setColumns(10);

		addAutores = new JLabel("");
		addAutores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String tipo = CbTipo.getSelectedItem().toString();
				String name = JtAutores.getText();
				if(tipo.equals("Libro")){
					if(name.equals("")){

					}
					else{
						autores.add(name);
						definirTabla(autores);
						JtAutores.setText("");
					}
				}
				else if(tipo.equals("Articulo")){
					if(name.equals("")){

					}
					else{
						arbitros.add(name);
						definirTabla(arbitros);
						JtAutores.setText("");
					}
				}
			}
		});
		addAutores.setVisible(false);
		addAutores.setHorizontalAlignment(SwingConstants.CENTER);
		addAutores.setIcon(new ImageIcon(AddPublicaciones.class.getResource("/Icons/icons8-plus-math-30.png")));
		addAutores.setBounds(336, 460, 40, 40);
		contentPane.add(addAutores);

		JtEditorial = new JTextField();
		JtEditorial.setVisible(false);
		JtEditorial.setColumns(10);
		JtEditorial.setBounds(460, 460, 270, 40);
		contentPane.add(JtEditorial);

		lblEditorial = new JLabel("Editorial");
		lblEditorial.setVisible(false);
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEditorial.setBounds(460, 425, 134, 20);
		contentPane.add(lblEditorial);

		lblAutores = new JLabel("Autores");
		lblAutores.setVisible(false);
		lblAutores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAutores.setBounds(65, 425, 134, 20);
		contentPane.add(lblAutores);

		scrollPane = new JScrollPane();
		scrollPane.setVisible(false);
		scrollPane.setBounds(65, 535, 669, 170);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setVisible(false);
		scrollPane.setColumnHeaderView(table);

		lblArbitros = new JLabel("Arbitros");
		lblArbitros.setVisible(false);
		lblArbitros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblArbitros.setBounds(65, 425, 134, 20);
		contentPane.add(lblArbitros);
		}
		private void definirTabla(ArrayList<String> aE){
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Identificador");
			modelo.addColumn("Nombre");
			for(int i=0;i<aE.size();i++){
				Object[] newRow = new Object[]{i+1,aE.get(i)};
				modelo.addRow(newRow);
			}
			pintarTablaEditores(modelo);
		}
		private void pintarTablaEditores(DefaultTableModel modelo){
			table = new JTable(modelo);

			scrollPane.setViewportView(table);
		}
	}
