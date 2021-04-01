package org.burakisik.osgi.aircraft.detector;

import javax.swing.JPanel;

public class Controller {
	
	private JPanel view;
	
	public Controller(DetectedAircraftListView view) {
		this.view = view;
	}
	
	public JPanel getView() {
		return view;
	}

}
