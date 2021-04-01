package org.burakisik.osgi.app;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.burakisik.osgi.common.service.ui.AircraftDetectorService;
import org.burakisik.osgi.common.service.ui.EmergencyService;
import org.burakisik.osgi.common.service.ui.GpsService;
import org.burakisik.osgi.common.service.utils.Environment;
import org.burakisik.osgi.logger.OSGiLoggerComponent;
import org.burakisik.osgi.user.interfaces.UiService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component
public class AppComponent {

	private final static Logger logger = LogManager.getLogger(AppComponent.class);

	@Activate
	protected void activate() {
		logger.info("AppComponent.activate()" );
		ServiceManager.getInstance().init();
		Environment environmentService = ServiceManager.getInstance().getEnvironmentService();
		
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			logger.info("JVM CPU usage %" + environmentService.cpuUsage().jvm());
			logger.info("System CPU usage %" + environmentService.cpuUsage().system());
		}
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
		// Logger logger = Logger.getLogger(AppComponent.class.getName());
		// loggerComponent.setLoggerProperties(logger);
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setEnvironmentService(Environment environment) {
		ServiceManager.getInstance().setEnvironmentService(environment);
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setAircraftDetectorService(AircraftDetectorService AircraftDetectorService) {
		ServiceManager.getInstance().setAircraftDetectorService(AircraftDetectorService);
	}

}
