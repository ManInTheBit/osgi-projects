package org.burakisik.osgi.declarative.service;

import org.burakisik.osgi.declarative.service.model.Location;

public interface GpsService {

	public void showCurrentLocation(Location location);
	
	public Location findCurrentLocation();
}
