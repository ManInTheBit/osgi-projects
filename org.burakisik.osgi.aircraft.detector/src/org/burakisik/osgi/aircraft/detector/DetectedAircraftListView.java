package org.burakisik.osgi.aircraft.detector;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DetectedAircraftListView extends JPanel {
	
    private JTable table;
	
	public DetectedAircraftListView() {
		init();
	}

	private void init() {
		table = new JTable();
        table.setModel(new CustomTableModel());
        table.setFillsViewportHeight(true);
        table.getColumnModel()
            .getColumn(1)
            .setCellRenderer(new CellRenderer());
        table.setRowHeight(40);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        add(scrollPane, BorderLayout.CENTER);
	}
}
