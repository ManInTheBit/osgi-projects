package org.burakisik.osgi.aircraft.detector.view;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.burakisik.osgi.aircraft.detector.data.Cell;

public class CellHolder extends JPanel {
	
	public CellHolder(Cell item) {
		 JLabel lblModel = new JLabel(item.model());
		 JLabel lblManufacturer = new JLabel(item.manufacturer());
		 JLabel lblYear = new JLabel(String.valueOf(item.completedYear()));
		 JLabel lblPhysicalClassByEngine = new JLabel(item.physicalClassByEngine());

		 add(lblYear);
	     add(lblModel);
	     add(lblManufacturer);
	     add(lblPhysicalClassByEngine);     
	}

}
