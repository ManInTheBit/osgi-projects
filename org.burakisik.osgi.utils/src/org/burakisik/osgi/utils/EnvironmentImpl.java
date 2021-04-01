package org.burakisik.osgi.utils;

import java.lang.management.ManagementFactory;
import org.burakisik.osgi.common.data.CpuUsage;
import org.burakisik.osgi.common.service.utils.Environment;
import org.burakisik.osgi.common.service.utils.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import com.sun.management.OperatingSystemMXBean;

@Component
public class EnvironmentImpl implements Environment {
	
	private StringUtils stringUtils;

	@Override
	public CpuUsage cpuUsage() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		CpuUsage cpuUsage = new CpuUsage(stringUtils.format(String.valueOf(osBean.getProcessCpuLoad()), 4), stringUtils.format(String.valueOf(osBean.getSystemCpuLoad()), 4));
		return cpuUsage;
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	public void setStringUtils(StringUtils stringUtils) {
		this.stringUtils = stringUtils; 
	}
	
}
