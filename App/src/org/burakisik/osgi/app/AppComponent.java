package org.burakisik.osgi.app;

import org.burakisik.osgi.declarative.service.EmergencyService;
import org.burakisik.osgi.declarative.service.GpsService;
import org.burakisik.osgi.logger.OSGiLoggerComponent;
import org.burakisik.osgi.user.interfaces.UiService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component
public class AppComponent {
	
	@Activate
	protected void activate() {
		System.out.println("AppComponent.activate()");
		ServiceManager.getInstance().init();
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setEmergencyService(EmergencyService emergencyService) {
		ServiceManager.getInstance().setEmergencyService(emergencyService);
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setGpsService(GpsService gpsService) {
		ServiceManager.getInstance().setGpsService(gpsService);
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setUi(UiService uiService) {
		ServiceManager.getInstance().setUi(uiService);
	}
	
	@Reference(cardinality = ReferenceCardinality.OPTIONAL)
	public void setLoggerService(OSGiLoggerComponent loggerComponent) {
		//Logger logger = Logger.getLogger(AppComponent.class.getName());
		//loggerComponent.setLoggerProperties(logger);
	}
}
