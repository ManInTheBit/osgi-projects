package org.burakisik.osgi.aircraft.detector.data;

import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

	private Class[] columnTypes = new Class[] { Integer.class, Cell.class };

	public CustomTableModel() {
		super(generateMockRowData(), new Object [] {"Order", "Aircraft"});
	}

	CustomTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}	

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
	
	private static Object[][] generateMockRowData() {
		return new Object[][] { new Object[] {1, cell() },
			new Object[] {2, cell() }};
	}
	
	private static Cell cell() {
		return new Cell(2018, "Aeronca" ,"7AC Champion", "Piston", (byte)2, 120, "Small Winglets", 35.00f, 21.50f, 7.00f);
	}

	private static Object[] generateMockHeaderData() {
		return (Object[])Cell.properties();
	}
}
