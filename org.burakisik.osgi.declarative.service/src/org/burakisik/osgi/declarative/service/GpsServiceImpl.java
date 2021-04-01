package org.burakisik.osgi.declarative.service;

import org.burakisik.osgi.common.data.Location;
import org.burakisik.osgi.common.service.ui.GpsService;
import org.osgi.service.component.annotations.Component;


@Component(service = GpsService.class, immediate = true)
public class GpsServiceImpl implements GpsService{

	@Override
	public void showCurrentLocation(Location location) {
		System.out.println("Show current location");
	}

	@Override
	public Location findCurrentLocation() {
		Location currentLocation = new Location(15.961329, 24.082031);
		return currentLocation;
	}
}
