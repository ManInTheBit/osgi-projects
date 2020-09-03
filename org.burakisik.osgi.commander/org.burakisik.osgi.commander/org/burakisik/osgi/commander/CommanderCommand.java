package org.burakisik.osgi.commander;

import java.util.HashMap;
import java.util.Map;


import org.burakisik.osgi.common.CommanderConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;



@Component(property = { "osgi.command.scope=test", "osgi.command.function=test2" }, service = CommanderCommand.class)
public class CommanderCommand {

	@Reference
	EventAdmin eventAdmin;

	public void test2(String command, String target) {

		Map<String, Object> properties = new HashMap<>();
		properties.put(CommanderConstants.TARGET, target);

		Event event;

		switch (command) {

		case "attack":
			event = new Event(CommanderConstants.TOPIC_ATTACK, properties);
			break;
		case "defend":
			event = new Event(CommanderConstants.TOPIC_DEFEND, properties);
			break;
		case "educate":
			event = new Event(CommanderConstants.TOPIC_EDUCATE, properties);
			break;
		case "all":
			event = new Event(CommanderConstants.TOPIC_ALL, properties);
			break;
		default:
			throw new UnsupportedOperationException(); // fail-fast principle
		}

		if (event != null)
			eventAdmin.postEvent(event);
	}
}
