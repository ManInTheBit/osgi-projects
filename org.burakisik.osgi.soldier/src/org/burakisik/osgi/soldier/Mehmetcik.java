package org.burakisik.osgi.soldier;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.burakisik.osgi.common.CommanderConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

@Component(property = { EventConstants.EVENT_TOPIC + "=" + CommanderConstants.TOPIC_ATTACK,
		EventConstants.EVENT_DELIVERY + "=" + EventConstants.DELIVERY_ASYNC_UNORDERED })
public class Mehmetcik implements EventHandler {
	final Logger logger = LogManager.getLogger(Mehmetcik.class);

	@Override
	public void handleEvent(Event event) {
		logger.info(event.getProperty(CommanderConstants.TARGET));
	}
	

}
