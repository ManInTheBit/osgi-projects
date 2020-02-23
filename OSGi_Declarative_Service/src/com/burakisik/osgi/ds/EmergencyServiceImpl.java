package com.burakisik.osgi.ds;

import org.osgi.service.component.annotations.Component;

@Component(service = EmergencyService.class, name = "com.burakisik.osgi.ds", immediate = true)
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
