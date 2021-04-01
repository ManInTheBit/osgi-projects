package org.burakisik.osgi.aircraft.detector;

import javax.swing.JPanel;

import org.burakisik.osgi.common.service.ui.AircraftDetectorService;
import org.osgi.service.component.annotations.Component;

@Component
public class AircraftDetectorServiceImpl implements AircraftDetectorService {

	@Override
	public JPanel getView() { 
		Controller controller = new Controller(new DetectedAircraftListView());
		return controller.getView();
	}
}
