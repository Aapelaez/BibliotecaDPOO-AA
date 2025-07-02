package GIU;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;

import Logica.Publicacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class EditPublicaciones extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public EditPublicaciones(final MainScreen father,final Publicacion edit) {
		super(father,true);
		setUndecorated(true);
		setBounds(100, 100, 561, 364);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 191, 255), 1, true));
		panel.setBounds(0, 0, 561, 385);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEditarPublicacion = new JLabel("Editar Publicacion");
		lblEditarPublicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarPublicacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEditarPublicacion.setBounds(156, 16, 212, 30);
		panel.add(lblEditarPublicacion);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		spinner.setBounds(142, 121, 270, 40);
		panel.add(spinner);
		
		JLabel label = new JLabel("Cantidad de Ejemplares:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(142, 84, 236, 20);
		panel.add(label);
		
		JButton button = new JButton("A\u00F1adir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ejemplares = (Integer) spinner.getValue();
				edit.setCantTotalEjemp(ejemplares); 
				dispose();
				father.Actualizar(1);
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(61, 253, 165, 40);
		panel.add(button);
		
		JButton button_1 = new JButton("Salir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		button_1.setBounds(329, 253, 165, 40);
		panel.add(button_1);
	}
}
