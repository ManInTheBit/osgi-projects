package org.burakisik.osgi.common.service.ui;

import org.burakisik.osgi.common.data.Location;

public interface GpsService {

	public void showCurrentLocation(Location location);
	
	public Location findCurrentLocation();
}
