package org.burakisik.osgi.logger;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class OSGiFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return new Date(record.getMillis()) + "::" 
				+ record.getLevel() + "::" 
				+ record.getSourceClassName() + "::"
				+ record.getSourceMethodName() + "::" 
				+ record.getSequenceNumber() + "::" 
				+ record.getMessage();
	}

}
