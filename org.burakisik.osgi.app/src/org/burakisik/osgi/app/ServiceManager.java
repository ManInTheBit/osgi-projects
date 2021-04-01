package org.burakisik.osgi.app;

import org.burakisik.osgi.common.utils.Environment;
import org.burakisik.osgi.declarative.service.EmergencyService;
import org.burakisik.osgi.declarative.service.GpsService;
import org.burakisik.osgi.user.interfaces.UiService;

public class ServiceManager {

	private UiService uiService;
	private GpsService gpsService;
	private Environment environmentService;
	private EmergencyService emergencyService;

	private static ServiceManager serviceManager;

	private ServiceManager() {

	}

	public static ServiceManager getInstance() {
		if (serviceManager == null)
			serviceManager = new ServiceManager();
		return serviceManager;
	}
	
	public void init() {
		emergencyService.showEmergencyDialog();
		gpsService.findCurrentLocation();
		uiService.getMainFrame();//.setVisible(true);
		uiService.getErrorDialog();
	}
	
	public void setEmergencyService(EmergencyService emergencyService) {
		this.emergencyService = emergencyService;
	}

	public void setGpsService(GpsService gpsService) {
	    this.gpsService = gpsService; 
	}

	public void setUi(UiService uiService) {
		this.uiService = uiService;
	}
	
	public void setEnvironmentService(Environment environmentService) {
		this.environmentService = environmentService;
	}
	
	public Environment getEnvironmentService() {
		return environmentService;
	}
}
