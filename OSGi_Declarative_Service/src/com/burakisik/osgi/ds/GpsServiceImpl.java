package com.burakisik.osgi.ds;

import org.osgi.service.component.annotations.Component;

@Component(service = GpsService.class, name = "com.burakisik.osgi.ds", immediate = true)
public class GpsServiceImpl implements GpsService{

	@Override
	public void showCurrentLocation(LocationModel location) {
		System.out.println("Show current location");
	}

	@Override
	public LocationModel findCurrentLocation() {
		LocationModel currentLocation = new LocationModel(15.961329, 24.082031);
		return currentLocation;
	}
}
