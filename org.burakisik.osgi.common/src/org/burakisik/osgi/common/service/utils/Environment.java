package org.burakisik.osgi.common.service.utils;

import org.burakisik.osgi.common.data.CpuUsage;
import org.burakisik.osgi.common.data.DisplayInfo;

public interface Environment {
	
	public CpuUsage cpuUsage();
	
	public DisplayInfo displayInfo();
	
}
