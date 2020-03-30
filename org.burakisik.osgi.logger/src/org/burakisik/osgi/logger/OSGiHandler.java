package org.burakisik.osgi.logger;


import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import org.osgi.service.component.annotations.*;

public class OSGiHandler extends StreamHandler {
	
	@Override
	public void publish(LogRecord record) {
		super.publish(record);
	}
	
	@Override
	public void flush() {
		super.flush();
	}
	
	@Override
	public void close() throws SecurityException {
		super.close();
	}
	
}