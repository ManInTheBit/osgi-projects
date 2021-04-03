package org.burakisik.osgi.aircraft.detector.view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import org.burakisik.osgi.aircraft.detector.data.Cell;

public class CellRenderer implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		return new CellHolder((Cell) value);
	}

}
