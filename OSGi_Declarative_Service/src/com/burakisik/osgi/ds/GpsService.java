package com.burakisik.osgi.ds;

public interface GpsService {

	public void showCurrentLocation(LocationModel location);
	
	public LocationModel findCurrentLocation();
}
