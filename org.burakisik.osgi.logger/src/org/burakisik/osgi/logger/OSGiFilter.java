package org.burakisik.osgi.logger;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class OSGiFilter implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		if(record.getLevel() == Level.INFO)
			return true;
		return false;
	}
}
