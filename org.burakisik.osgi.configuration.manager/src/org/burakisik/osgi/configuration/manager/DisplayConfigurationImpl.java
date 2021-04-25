package org.burakisik.osgi.configuration.manager;

import java.util.List;

import org.burakisik.osgi.common.service.configuration.DisplayConfigurationService;
import org.osgi.service.component.annotations.Component;

@Component
public class DisplayConfigurationImpl implements DisplayConfigurationService {

	@Override
	public void saveLayout() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addNewPanel() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean removePanel(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> allPanelsName() {
		// TODO Auto-generated method stub
		return null;
	}

}
