package com.burakisik.osgi.log;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LogComponent {
	
	final Logger logger = LoggerFactory.getLogger(LogComponent.class);

	@Activate
	public void activate() {
		logger.info("test-log4j");
	}

	@Deactivate
	public void Deactivate() {

	}
}
