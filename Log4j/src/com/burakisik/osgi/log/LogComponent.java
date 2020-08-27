package com.burakisik.osgi.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
public class LogComponent {
	   
	@Activate
	public void activate() {
		System.setProperty("log4j.configurationFile",  "log4j.xml");
	    final Logger logger = LogManager.getLogger();
		logger.info("test-log4j");
		//readConfig();
		
	}

	@Deactivate
	public void Deactivate() {

	}
}
