package org.burakisik.osgi.logger;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Component
public class OSGiLoggerComponent {

	@Activate
	public void activate() {

		readConfig();
		
	}

	@Deactivate
	public void Deactivate() {

	}
	
	private void readConfig() {
		try {
			LogManager.getLogManager().readConfiguration(this.getClass().getClassLoader().getResourceAsStream("applog.properties"));
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setLoggerProperties(Logger logger) {
		logger.setLevel(Level.INFO);
		logger.addHandler(new ConsoleHandler());
		logger.addHandler(new OSGiHandler());
		
		try {
			Handler fileHandler = new FileHandler("../../../temp/logger.log", 2000, 5);
			fileHandler.setFormatter(new OSGiFormatter());
			fileHandler.setFilter(new OSGiFilter());
			logger.addHandler(fileHandler);
			logger.log(Level.INFO,"message");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
}
