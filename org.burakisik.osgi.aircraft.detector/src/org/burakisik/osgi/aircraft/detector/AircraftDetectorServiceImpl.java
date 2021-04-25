package org.burakisik.osgi.aircraft.detector;

import javax.swing.JPanel;

import org.burakisik.osgi.aircraft.detector.view.DetectedAircraftListView;
import org.burakisik.osgi.common.data.Placement;
import org.burakisik.osgi.common.service.ui.AircraftDetectorService;
import org.burakisik.osgi.common.type.LocationOnScreen;
import org.osgi.service.component.annotations.Component;

@Component
public class AircraftDetectorServiceImpl implements AircraftDetectorService {

	@Override
	public JPanel getView() { 
		Placement placement = new Placement(LocationOnScreen.CENTER, 1);
		Controller controller = new Controller(new DetectedAircraftListView(placement));
		return controller.getView();
	}
}
