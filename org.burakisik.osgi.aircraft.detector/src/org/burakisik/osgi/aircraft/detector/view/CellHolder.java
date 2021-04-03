package org.burakisik.osgi.aircraft.detector.view;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.burakisik.osgi.aircraft.detector.data.Cell;

public class CellHolder extends JPanel {
	
	public CellHolder(Cell item) {
		 JCheckBox chckbxSomeValue = new JCheckBox();
	     chckbxSomeValue.setSelected(item.flag());
		 JLabel lblNewLabel = new JLabel(item.text());
	    
	     add(lblNewLabel);
	     add(chckbxSomeValue);
	}

}
