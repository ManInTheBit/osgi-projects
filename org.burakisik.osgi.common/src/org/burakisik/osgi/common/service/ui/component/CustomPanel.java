package org.burakisik.osgi.common.service.ui.component;

import javax.swing.JPanel;

import org.burakisik.osgi.common.data.Placement;

public class CustomPanel extends JPanel {
	
	private static final long serialVersionUID = 5465366551406835628L;
	private Placement placement;

	public CustomPanel(Placement placement) {
		this.placement = placement;
		//setLocation(placement.size().x, placement.size().y);
		//setSize(placement.size().width, placement.size().height);
	}
	
	public Placement getPlacement() {
		return placement;
	}
}
