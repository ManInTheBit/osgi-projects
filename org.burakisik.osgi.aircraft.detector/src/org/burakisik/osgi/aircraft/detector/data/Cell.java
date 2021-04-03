package org.burakisik.osgi.aircraft.detector.data;

import java.util.Date;

public record Cell(int completedYear, String manufacturer, String model, String physicalClassByEngine, byte engineCount, int approachSpeedByVref, String wingtipConfiguration, float wingSpanByFt, float lenghtByFt, float wheelBaseByFt) {

	public static String [] properties() {
		return new String [] {
				"Completed Year", "Manufacturer", "Model", "Physical Class(Engine)", "Engine Count", "Approach Speed(vref)", "Wingtip Configuration", "Wing Span(ft)", "Lenght(ft)", "wheel Base(ft)"
		};
	}
}
