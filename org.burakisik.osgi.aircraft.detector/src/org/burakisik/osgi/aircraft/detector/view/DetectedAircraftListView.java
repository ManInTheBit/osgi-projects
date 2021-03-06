package org.burakisik.osgi.aircraft.detector.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.burakisik.osgi.aircraft.detector.data.CustomTableModel;
import org.burakisik.osgi.common.data.Placement;
import org.burakisik.osgi.common.service.ui.component.CustomPanel;

public class DetectedAircraftListView extends CustomPanel {
	
    private JTable table;
	
	public DetectedAircraftListView(Placement placement) {
		super(placement);
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
