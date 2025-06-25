package GIU;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class CustomTable extends JTable {
    public CustomTable() {
        super();
    }
    public CustomTable(List<String> columnNames, Object[][] data) {

        DefaultTableModel model = new DefaultTableModel(data, columnNames.toArray()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        setModel(model);

        // Aplicar estilos
        applyTableStyles();

        // Configurar listener de doble click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = rowAtPoint(e.getPoint());
                }
            }
        });
    }
        private void applyTableStyles() {
            // Estilos básicos
            setBackground(Color.WHITE);

            setFont(new Font("Tahoma", Font.PLAIN, 14));
            setRowHeight(30);
            setGridColor(Color.GRAY);

            // Encabezado
            JTableHeader header = getTableHeader();
            header.setBackground(Color.BLUE);
            header.setForeground(Color.WHITE);
            header.setFont(new Font("Arial", Font.BOLD, 14));

            // Centrar contenido
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            for (int i = 0; i < getColumnCount(); i++) {
                getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }





}