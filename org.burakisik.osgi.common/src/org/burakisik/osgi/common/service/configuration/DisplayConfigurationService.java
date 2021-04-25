package org.burakisik.osgi.common.service.configuration;

import java.util.List;

public interface DisplayConfigurationService {
	
	public void saveLayout();
	
	public void addNewPanel();
	
	public boolean removePanel(String name);
	
	public List<String> allPanelsName();
}
