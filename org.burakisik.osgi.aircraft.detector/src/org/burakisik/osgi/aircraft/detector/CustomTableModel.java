package org.burakisik.osgi.aircraft.detector;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel {

	private Class[] columnTypes = new Class[] { Integer.class, Cell.class };

	public CustomTableModel() {
		super(new Object[][] { new Object[] { 1, new Cell("item1", true) },
				new Object[] { 2, new Cell("item2", false) }, new Object[] { 2, new Cell("item3", false) } },
				new String[] { "Id", "State" });
	}

	CustomTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}	

	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
}
