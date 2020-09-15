package org.burakisik.osgi.app;

import java.lang.management.ManagementFactory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.sun.management.OperatingSystemMXBean;

public class AppUtils {

	private static final Logger logger = LogManager.getLogger(AppUtils.class);

	public static void printCpuUsage() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		logger.info("JVM CPU usage %" + osBean.getProcessCpuLoad());
		logger.info("System CPU usage %" + osBean.getSystemCpuLoad());
	}

}
