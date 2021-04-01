package org.burakisik.osgi.aircraft.detector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CellHolder extends JPanel {
	
	public CellHolder(Cell item) {
		 JCheckBox chckbxSomeValue = new JCheckBox();
	     chckbxSomeValue.setSelected(item.flag());
		 JLabel lblNewLabel = new JLabel(item.text());
	    
	     add(lblNewLabel);
	     add(chckbxSomeValue);
	}

}
