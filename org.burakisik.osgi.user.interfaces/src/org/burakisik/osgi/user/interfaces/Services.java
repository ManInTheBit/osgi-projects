package org.burakisik.osgi.user.interfaces;

import org.burakisik.osgi.common.service.i18n.InternationalizationService;
import org.burakisik.osgi.common.service.ui.AircraftDetectorService;

public class Services {
	
	private static Services instance;
	private InternationalizationService i18n;
	private AircraftDetectorService aircraftDetectorService;
	
	private Services() {
		
	}
	
	public static Services getInstance() {
		if(instance == null) {
			instance = new Services();
		}
		return instance;
	}

	public InternationalizationService getI18n() {
		return i18n;
	}

	public void setI18n(InternationalizationService i18n) {
		this.i18n = i18n;
	}

	public void setAircraftDetectorService(AircraftDetectorService aircraftDetectorService) {
		this.aircraftDetectorService = aircraftDetectorService;
	}
	
	public AircraftDetectorService getAircraftDetectorService() {
		return aircraftDetectorService;
	}
}
