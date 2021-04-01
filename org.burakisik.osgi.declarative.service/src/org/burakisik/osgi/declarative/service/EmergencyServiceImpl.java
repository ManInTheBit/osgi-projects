package org.burakisik.osgi.declarative.service;

import org.burakisik.osgi.common.service.ui.EmergencyService;
import org.osgi.service.component.annotations.Component;

@Component(service = EmergencyService.class, immediate = true)
public class EmergencyServiceImpl implements EmergencyService{

	@Override
	public void showEmergencyDialog() {
		System.out.println("Show emergency dialog");
	}

	@Override
	public void activateSoundAlarm() {
		System.out.println("Activate sound alarm");
	}
}
